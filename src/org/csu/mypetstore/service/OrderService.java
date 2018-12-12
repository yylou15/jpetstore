package org.csu.mypetstore.service;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.csu.mypetstore.dao.ItemDAO;
import org.csu.mypetstore.dao.LineItemDAO;
import org.csu.mypetstore.dao.OrderDAO;
import org.csu.mypetstore.dao.SequenceDAO;
import org.csu.mypetstore.dao.impl.ItemDAOImpl;
import org.csu.mypetstore.dao.impl.LineItemDAOImpl;
import org.csu.mypetstore.dao.impl.OrderDAOImpl;
import org.csu.mypetstore.dao.impl.SequenceDAOImpl;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.LineItem;
import org.csu.mypetstore.domain.Order;
import org.csu.mypetstore.domain.Sequence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {
    private LineItemDAO lineItemDAO;
    private SequenceDAO sequenceDAO;
    private ItemDAO itemDAO1;
    private OrderDAO orderDAO;

    public OrderService() {
        lineItemDAO = new LineItemDAOImpl();
        sequenceDAO = new SequenceDAOImpl();
        itemDAO1 = new ItemDAOImpl();
        orderDAO = new OrderDAOImpl();
    }

    public void insertOrder(Order order) {
    order.setOrderId(getNextId("ordernum"));
    for (int i = 0; i < order.getLineItems().size(); i++) {
        LineItem lineItem = (LineItem) order.getLineItems().get(i);
        String itemId = lineItem.getItemId();
        Integer increment = new Integer(lineItem.getQuantity());
        Map<String, Object> param = new HashMap<String, Object>(2);
        param.put("itemId", itemId);
        param.put("increment", increment);
        itemDAO1.updateInventoryQuantity(param);
    }

    orderDAO.insertOrder(order);
    orderDAO.insertOrderStatus(order);
    for (int i = 0; i < order.getLineItems().size(); i++) {
        LineItem lineItem = (LineItem) order.getLineItems().get(i);
        lineItem.setOrderId(order.getOrderId());
        lineItemDAO.insertLineItem(lineItem);
    }
}


    public Order getOrder(int orderId) {
        Order order = orderDAO.getOrder(orderId);
        order.setLineItems(lineItemDAO.getLineItemsByOrderId(orderId));

        for (int i = 0; i < order.getLineItems().size(); i++) {
            LineItem lineItem = (LineItem) order.getLineItems().get(i);
            Item item = itemDAO1.getItem(lineItem.getItemId());
            item.setQuantity(itemDAO1.getInventoryQuantity(lineItem.getItemId()));
            lineItem.setItem(item);
        }

        return order;
    }

    public List<Order> getOrdersByUsername(String username) {
        return orderDAO.getOrdersByUsername(username);
    }

    public int getNextId(String name) {
        Sequence sequence = new Sequence(name, -1);
        sequence = (Sequence) sequenceDAO.getSequence(sequence);
        if (sequence == null) {
            throw new RuntimeException("Error: A null sequence was returned from the database (could not get next " + name
                    + " sequence).");
        }
        Sequence parameterObject = new Sequence(name, sequence.getNextId() + 1);
        sequenceDAO.updateSequence(parameterObject);
        return sequence.getNextId();
    }


}
