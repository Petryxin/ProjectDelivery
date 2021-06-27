# application
For Exposit

    Firstly, I create objects like Delivery, User, Shop, Product, using their Service classes.
We have user with registration. He can find shops with the required category. After that, he can choose the shop he wants. Then he will see list of products with certain category. (User doesn’t see products with field – number = 0). We can sorted list of products in ascending or descending price, find products by name or by name and manufacturer.
    Create object Order with our user and empty shopping list. Than user can add products to list. Products can be from different shops. (Different shops may contain the same products with different or the same price. One product can contain more than one category of product because it has List<Category>). 
    When user added product to shopping list, field “costOfProducts” on object “Order” was changed by method “calculateCostOfProducts”. At the same time field “numberOfProducts” on object “Product” was changed by method “decreaseInNumberOfProducts”.
    All data is saved in a file - data.json.
