package com.openclassrooms.shop.domain;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    //Private fields to be added
    List<CartLine> cartLines = new ArrayList<>();

    /**
     * @return the actual cartline list
     */
    public List<CartLine> getCartLineList() {
        //TODO implement the method
        return cartLines;
    }

    /**
     * Adds a getProductById in the cart or increment its quantity in the cart if already added
     *
     * @param product  getProductById to be added
     * @param quantity the quantity
     */
    public void addItem(Product product, int quantity) {
        // TODO implement the method
        //Add if-check with incrementation if already exists
        for (CartLine cartLine : cartLines) {
            if (cartLine.getProduct().equals(product)) {
                int newQuantity = cartLine.getQuantity() + quantity;
                cartLine.setQuantity(newQuantity);
                return;
            }
        }
        CartLine cartline = new CartLine(product, quantity);
        cartLines.add(cartline);
    }

    /**
     * Removes a getProductById form the cart
     *
     * @param product the getProductById to be removed
     */
    public void removeLine(Product product) {
//        getCartsLineList().removeIf(l -> l.getProduct().getId().equals(product.getId()));
    }


    /**
     * @return total value of a cart
     */
    public double getTotalValue() {
        //TODO implement the method
        return 0.0;

    }

    /**
     * @return Get average value of a cart
     */
    public double getAverageValue() {
        // TODO implement the method
        Double runningTotal = 0.0;
        Double average = 0.0;
        for (CartLine cartLine : cartLines) {
            runningTotal +=cartLine.getSubtotal();
            if(!cartLines.iterator().hasNext()){
                average = runningTotal / cartLines.size();
            }
        }
        return average;
    }

    /**
     * @param productId the getProductById id to search for
     * @return getProductById in the cart if it finds it
     */
    public Product findProductInCartLines(Long productId) {
        // TODO implement the method
        for (int i = 0; i < cartLines.size(); i++){
            if (cartLines.get(i).getProduct().getId().equals(productId)){
                return cartLines.get(i).getProduct();
            }
        }
        return null;
    }

    /**
     * @param index index of the cartLine
     * @return CartLine in that index
     */
    public CartLine getCartLineByIndex(int index) {
        CartLine foundCartline = cartLines.get(index);
        return foundCartline;
    }

    /**
     * Clears a the cart of all added products
     */
    public void clear() {
        List<CartLine> cartLines = getCartLineList();
        cartLines.clear();
    }
}