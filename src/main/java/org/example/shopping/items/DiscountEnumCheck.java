package org.example.shopping.items;

public class DiscountEnumCheck {
    public static  Boolean checkEnumFields(String userInput) {
        for( Discount discount : Discount.values()) {
            if (userInput.equalsIgnoreCase(discount.name())) {
                return true;
            }
        }
        return false;
    }
}
