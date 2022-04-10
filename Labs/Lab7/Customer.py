# Class Customer
class Customer():
    # Defining the variables
    name = ""
    productDict = {}
    
    # Class constructor, takes in the object, the name of the customer 
    # and a dictionary of products with respective prices 
    def __init__(self,n,d):
        self.name = n
        self.productDict = d
    # Function to add a product to the dictionary 
    def addProduct(self,prodName,prodPrice):
        self.productDict[prodName] = prodPrice
        print("Products added")
    # Function to print the dictionary product by product, with their respective prices 
    # The object ("person" in this case) is also an argument, hence "self" as parameter of the function
    def printDict(self):
        for x in self.productDict:
            # x is the name (key) of the product and prodDict[x] is the value
            print(x, self.productDict[x])
    # Function to only print products with a price greater than the "minimum" value passed as parameter         
    def printSpecificDict(self, minimum):
        for x in self.productDict:
            if self.productDict[x] > minimum:
                print(x)
        
        
# Main method
# Initial Dictionary
prodDict = {'Bread': 3.2,'Pasta':2.99}    
# Creating an object of type Customer called "person"
# Passing the name of the person and the initial Dictionary containing the products
person = Customer("Bianca",prodDict)

# Adding products using the function addProducts() 
print("Adding products to customer's grocery shopping")
person.addProduct('Tomato',1.82)
person.addProduct('Pesto', 3.33)
person.addProduct('Plastic Fork', 0.88)

# Printing all products and respective prices with the function printDict()
print("All products with their prices:")
person.printDict()

# Printing all products with a price higher than 2 "euros"
print("Products above 2 euros: ")
person.printSpecificDict(2)