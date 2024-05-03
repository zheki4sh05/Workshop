package main;

import java.util.List;

public interface CustomerWorkShop {
    double calculateTotalAmount(List<WService>ordersList);
    double calculateTotalInDays(List<WService> ordersList);
}
