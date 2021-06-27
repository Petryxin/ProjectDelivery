package com.exposit.service;

import com.exposit.models.Category;
import com.exposit.models.Product;
import com.exposit.models.Shop;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ShopService {
    public Shop shopRegistrationInDelivery(String shopName, String shopAddress, List<Product> listProducts){
        Shop shop = new Shop(shopName,shopAddress,listProducts);
        return shop;
    }

    public void changeShopName(Shop shop, String shopName){
        shop.setShopName(shopName);
    }

    public void deleteShopName(Shop shop){
        shop.setShopName(null);
    }

    public void changeShopAddress(Shop shop, String shopAddress){
        shop.setShopAddress(shopAddress);
    }

    public void deleteShopAddress(Shop shop){
        shop.setShopAddress(null);
    }

    public void addProductToShop(Shop shop, Product product){
        List<Product> listProducts = shop.getListProducts();
        listProducts.add(product);
    }

    public void removeProductFromShop(Shop shop, Product product){
        List<Product> listProducts = shop.getListProducts();
        listProducts.remove(product);
    }

    public Product selectedProductFromList(Shop shop, Product product){
        List<Product> listProducts = shop.getListProducts();
        Product selectedProduct = listProducts.stream().filter(prod -> prod.equals(product))
                .findAny().orElse(null);
        return selectedProduct;
    }

    public List<Product> getProductByCategory(Shop shop, Category category) {
        List<Product> listProducts = shop.getListProducts();
        final List<Product> listOfProducts = listProducts.stream().filter(product -> product.getCategoryList()
                .stream().anyMatch(categ -> categ.equals(category))).filter(prod -> prod.getNumberOfProducts() > 0)
                .collect(Collectors.toList());
        return listOfProducts;
    }

    public List<Product> getListOfProductsInShop(Shop shop){
        List<Product> listProducts = shop.getListProducts();
        List<Product> productList = listProducts.stream().filter(product -> product.getNumberOfProducts() > 0)
                .collect(Collectors.toList());
        return productList;
    }

    public List<Product> sortProductsInAscendingPrice(List<Product> productList){
        List<Product> sortedListOfProducts = productList.stream()
                .sorted(Comparator.comparingInt(Product::getProductCost)).collect(Collectors.toList());
        return sortedListOfProducts;
    }

    public List<Product> sortProductsInDescendingPrice(List<Product> productList){
        List<Product> sortedListOfProducts = productList.stream()
                .sorted(Comparator.comparingInt(Product::getProductCost).reversed()).collect(Collectors.toList());
        return sortedListOfProducts;
    }

    public List<Product> findProductBytName(Shop shop, String productName) {
        List<Product> listProducts = shop.getListProducts();
        List<Product> listOfProducts = listProducts.stream().filter(product -> product.getProductName()
                .equals(productName)).collect(Collectors.toList());
        if (listOfProducts.size() == 0) {
            System.out.println("Product doesn't found");
        }
        return listOfProducts;
    }

    public List<Product> findProductByNameAndManufacturer(Shop shop, String productName, String manufacturer) {
        List<Product> listProducts = shop.getListProducts();
        List<Product> listOfProducts = listProducts.stream().filter(product -> product.getProductName()
                .equals(productName)).filter(product -> product.getManufacturer().equals(manufacturer))
                .collect(Collectors.toList());
        if (listOfProducts.size() == 0) {
            System.out.println("Product doesn't found");
        }
        return listOfProducts;
    }

    public Product getProduct(Shop shop, Product product) {
        List<Product> listProducts = shop.getListProducts();
        return listProducts.stream().filter(u -> u.getProductName().equals(product.getProductName()))
                .findAny().orElse(null);
    }

    public void changeCostOfProduct(Shop shop, Product product, int newCostOfProduct){
        Product productBeforeUpdate = getProduct(shop, product);
        if (productBeforeUpdate == null){
            System.out.println("We don't have this product - " + product.getProductName() + " in our shop");
        }else{
            productBeforeUpdate.setProductCost(newCostOfProduct);
        }
    }

    public void deleteCostOfProduct(Shop shop, Product product){
        Product productBeforeUpdate = getProduct(shop, product);
        if (productBeforeUpdate == null){
            System.out.println("We don't have this product - " + product.getProductName() + " in our shop");
        }else{
            productBeforeUpdate.setProductCost(0);
        }
    }

    public void changeProductName(Shop shop, Product product, String productName){
        Product productBeforeUpdate = getProduct(shop, product);
        if (productBeforeUpdate == null){
            System.out.println("We don't have this product - " + product.getProductName() + " in our shop");
        }else{
            productBeforeUpdate.setProductName(productName);
        }
    }

    public void deleteProductName(Shop shop, Product product){
        Product productBeforeUpdate = getProduct(shop, product);
        if (productBeforeUpdate == null){
            System.out.println("We don't have this product - " + product.getProductName() + " in our shop");
        }else{
            productBeforeUpdate.setProductName(null);
        }
    }

    public void changeNumberOfProducts(Shop shop, Product product, int numberOfProducts){
        Product productBeforeUpdate = getProduct(shop, product);
        if (productBeforeUpdate == null){
            System.out.println("We don't have this product - " + product.getProductName() + " in our shop");
        }else{
            productBeforeUpdate.setNumberOfProducts(numberOfProducts);
        }
    }

    public void decreaseInNumberOfProducts(Shop shop, Product product){
        Product productBeforeUpdate = getProduct(shop, product);
        if (productBeforeUpdate == null || product.getNumberOfProducts() == 0){
            System.out.println("We don't have this product - " + product.getProductName() + " in our shop");
        }else{
            int modifiedValueOfNumber = product.getNumberOfProducts() - 1;
            productBeforeUpdate.setNumberOfProducts(modifiedValueOfNumber);

        }
    }

    public void deleteNumberOfProducts(Shop shop, Product product){
        Product productBeforeUpdate = getProduct(shop, product);
        if (productBeforeUpdate == null){
            System.out.println("We don't have this product - " + product.getProductName() + " in our shop");
        }else{
            productBeforeUpdate.setNumberOfProducts(0);
        }
    }

    public void addCategoryToProduct(Shop shop, Product product, Category category){
        Product productBeforeUpdate = getProduct(shop, product);
        if (productBeforeUpdate == null){
            System.out.println("We don't have this product - " + product.getProductName() + " in our shop");
        }else{
            productBeforeUpdate.getCategoryList().add(category);
        }
    }

    public void deleteCategoryFromProduct(Shop shop, Product product, Category category){
        Product productBeforeUpdate = getProduct(shop, product);
        if (productBeforeUpdate == null){
            System.out.println("We don't have this product - " + product.getProductName() + " in our shop");
        }else{
            productBeforeUpdate.getCategoryList().remove(category);
        }
    }
}
