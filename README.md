
# Inventory Management System

This repository contains an implementation of an inventory management system for a provision store. The system utilizes various data structures and algorithms to efficiently manage the store's inventory and facilitate operations such as adding goods, viewing vendors, viewing goods, viewing bills, and tracking issued goods.

## Categories

The provision store deals with various categories of products. Here are some of the categories included in the system:

1. Beverages - coffee/tea, juice, soda
2. Bread/Bakery - sandwich loaves, dinner rolls, tortillas, bagels
3. Canned/Jarred Goods - vegetables, spaghetti sauce, ketchup
4. Dairy Products - cheeses, eggs, milk, yoghurt, butter
5. Dry/Baking Goods - cereals, flour, sugar, pasta, mixes
6. Frozen Products - waffles, vegetables, individual meals, ice cream
7. Meat - lunch meat, poultry, beef, pork
8. Farm Produce - fruits, vegetables
9. Home Cleaners - all-purpose, laundry detergent, dishwashing liquid/detergent
10. Paper Goods - paper towels, toilet paper, aluminium foil, sandwich bags
11. Home Care - shampoo, soap, hand soap, shaving cream

Please note that the provided list is just a sample, and additional items can be added to each category as needed.

## Data Structure Implementation

To efficiently manage the inventory, the following data structures have been implemented:

1. Stacks - used when adding and removing items in categories 1 to 4 (Beverages, Bread/Bakery, Canned/Jarred Goods, Dairy Products).
2. Queues - used when adding and removing items in categories 5 to 7 (Dry/Baking Goods, Frozen Products, Meat).
3. Lists - used when adding and removing items in categories 8 to 11 (Farm Produce, Home Cleaners, Paper Goods, Home Care).
4. Iterators, Recursion, and other techniques - employed for efficient management of issued goods, viewing goods, and bills.
5. Maps - utilized to keep track of product sales. Each time a product is sold, its product code is recorded in a sales file.
6. HashMaps - employed to store information about the vendors.

By leveraging these data structures and algorithms, the inventory management system ensures optimal performance and enables seamless operations for the provision store.

Please feel free to explore the source code in this repository to gain a deeper understanding of the implementation details.

**Note:** This document serves as a high-level overview of the inventory management system. For detailed documentation and instructions, please refer to the relevant source code files and comments within the repository.
