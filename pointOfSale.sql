CREATE DATABASE pointOfSale;
USE pointOfSale;

CREATE TABLE Employee (
  ssn  char(9),
  fname  varchar(15) not null,
  lname varchar(15) not null,
  bday varchar(10) not null,
  mgrssn char(9),
  isActive boolean,
  primary key (ssn),
  foreign key (mgrssn) references Employee(ssn)
);

CREATE TABLE Schedule (
  totalHours  integer,     -- The total number of hours an employee is scheduled to work in a week
  scheduleID  char(9),
  ssn char(9),
  daysWorking varchar(13), -- Days an employee is scheduled to work during a particular week
  
  /* The specific times during the given week that the employee is scheduled to start their work day */
  monTimeWorking time,
  tuesTimeWorking time,
  wedTimeWorking time,
  thursTimeWorking time,
  friTimeWorking time,

  primary key (scheduleID),
  foreign key (ssn) references Employee(ssn)
);

CREATE TABLE MenuItem (
  itemName varchar(40),
  price  integer,
  allergyStatus  varchar(35),
  vegetarianStatus  varchar(3),
  glutenFreeStatus  varchar(3),
  typeItem varchar(10),
  primary key (itemName)
);

CREATE TABLE CustomerOrder (
  ssn char(9),
  itemName varchar(40),
  orderNum  integer,
  orderQuantity integer,
  primary key (orderNum),
  foreign key (ssn) references Employee(ssn),
  foreign key (itemName) references MenuItem(itemName) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Ticket (
  ticketNum integer,
  ticketDate date,
  orderNum integer,
  primary key (ticketNum, orderNum),
  foreign key (orderNum) references CustomerOrder (orderNum) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Inventory (
  ingredientName varchar(25),
  ingredientQuantity integer,  -- Total amount of the ingredient available
  menuItemUsedIn varchar(100), -- The name of the menu item(s) that use the ingredient
  orderingManager char(9),
  primary key (ingredientName),
  foreign key (orderingManager) references Employee(ssn)
);

CREATE TABLE MenuIngredientUsage (
  menuItemName varchar(40),            -- Name of the menu item
  inventoryIngredientName varchar(25), -- Name of the ingredient
  ingredientAmntUsed integer,          -- The amount of the ingredient that has to be used to create the menu item
  primary key (menuItemName, inventoryIngredientName),
  foreign key (menuItemName) references MenuItem(itemName) ON DELETE CASCADE ON UPDATE CASCADE,
  foreign key (inventoryIngredientName) references Inventory(ingredientName) ON DELETE CASCADE ON UPDATE CASCADE
);



INSERT INTO Employee VALUES ("123456789", "Michael",   "Carter", "2002-10-11",        null, true);
INSERT INTO Employee VALUES ("112255438", "Kimberly",    "Gray", "1997-08-21",        null, true);
INSERT INTO Employee VALUES ("135797531", "Elizabeth", "Nelson", "2000-03-01",        null, true);
INSERT INTO Employee VALUES ("246864246", "Richard",    "James", "2001-03-30",        null, true);
INSERT INTO Employee VALUES ("763234551", "James",      "Myers", "1989-02-28",        null, true);
INSERT INTO Employee VALUES ("555555555", "Ruth",      "Thomas", "1999-12-02",        null, true);
INSERT INTO Employee VALUES ("926374289", "Sarah",     "Wilson", "2004-07-15",        null, true);
INSERT INTO Employee VALUES ("832556974", "James",     "Miller", "1980-09-27",        null, true);
INSERT INTO Employee VALUES ("449620351", "Emerson",   "Miller", "2002-05-09",        null, true);
INSERT INTO Employee VALUES ("670547720", "Taylor",   "Roberts", "2000-01-01",        null, true);
INSERT INTO Employee VALUES ("111222333", "Robert",      "Ross", "1994-04-20", "123456789", true);
INSERT INTO Employee VALUES ("197355426", "Ryan",       "Moore", "2005-10-10", "112255438", true);
INSERT INTO Employee VALUES ("222222222", "William",   "Parker", "1996-11-28", "135797531", true);
INSERT INTO Employee VALUES ("772655819", "Maria",     "Butler", "2001-02-27", "246864246", true);
INSERT INTO Employee VALUES ("444444444", "Lisa",      "Harris", "2000-03-01", "763234551", true);
INSERT INTO Employee VALUES ("629354882", "Joseph",    "Turner", "2003-11-07", "555555555", true);
INSERT INTO Employee VALUES ("111111112", "Annabeth",  "Garcia", "1985-10-06", "926374289", true);
INSERT INTO Employee VALUES ("111111113", "Richard",  "Collins", "2001-04-01", "832556974", true);
INSERT INTO Employee VALUES ("335336337", "Lillian",    "Perry", "2002-11-12", "449620351", true);
INSERT INTO Employee VALUES ("599431111", "Michael",     "Gray", "2005-03-14", "670547720", true);
INSERT INTO Employee VALUES ("499622555", "Margaret", "Roberts", "1994-06-20", "123456789", true);
INSERT INTO Employee VALUES ("763333318", "Brian",       "Cook", "2004-09-19", "112255438", true);
INSERT INTO Employee VALUES ("888899991", "Teresa",    "Howard", "1989-10-16", "135797531", true);
INSERT INTO Employee VALUES ("283664357", "Jessica",     "Ross", "1999-12-24", "123456789", true);
INSERT INTO Employee VALUES ("888888888", "Lisa",    "Thompson", "1992-05-05", "112255438", true);
INSERT INTO Employee VALUES ("987654321", "David", "Richardson", "1991-11-11", "135797531", true);
INSERT INTO Employee VALUES ("975322164", "Mary",       "Jones", "1990-09-22", "926374289", true);
INSERT INTO Employee VALUES ("777333444", "Jordan",    "Miller", "2002-10-06", "832556974", true);
INSERT INTO Employee VALUES ("777999000", "Tristan",   "Graham", "1993-02-09", "449620351", true);
INSERT INTO Employee VALUES ("777462111", "Taylor",    "Bryant", "2000-04-25", "670547720", true);

INSERT INTO Schedule VALUES (40, "111112345", "987654321", "M, T, W, R, F", "08:00", "08:00", "08:00", "08:00", "08:00");
INSERT INTO Schedule VALUES (40, "111112346", "888888888", "M, T, W, R, F", "08:00", "08:00", "08:00", "08:00", "08:00");
INSERT INTO Schedule VALUES (36, "111112347", "283664357", "M, T, W, R",    "12:00", "09:00", "09:00", "09:00",    null);
INSERT INTO Schedule VALUES (16, "111112348", "888899991", "M, W, R, F",    "09:00",    null, "11:00", "09:00", "11:00");
INSERT INTO Schedule VALUES ( 8, "111112349", "763333318", "R, F",             null,    null,    null, "14:00", "14:00");
INSERT INTO Schedule VALUES (24, "111112350", "499622555", "T, W, R",          null, "10:00", "12:00", "10:00",    null);
INSERT INTO Schedule VALUES (40, "111112351", "599431111", "M, R, F",       "14:00",    null,    null, "10:00", "07:00");
INSERT INTO Schedule VALUES (40, "111112352", "335336337", "T, W",             null, "10:00", "09:00",    null,    null);
INSERT INTO Schedule VALUES (32, "111112353", "111111113", "M, T, W, R, F", "10:00", "07:00", "10:00", "07:00", "09:00");
INSERT INTO Schedule VALUES (20, "111112354", "111111112", "M, T, W, R, F", "07:00", "10:00", "07:00", "10:00", "09:00");

INSERT INTO MenuItem VALUES ("Salad",                     6, "Tomato",                           "Yes",  "No",     "Entree");
INSERT INTO MenuItem VALUES ("Hamburger",                11, "Wheat, Soy, Yeast, Tomato",         "No",  "No",     "Entree");
INSERT INTO MenuItem VALUES ("Cheese Pizza",              8, "Dairy, Egg, Wheat, Yeast, Tomato", "Yes",  "No",     "Entree");
INSERT INTO MenuItem VALUES ("Pepperoni Pizza",           9, "Dairy, Egg, Wheat, Yeast",          "No",  "No",     "Entree");
INSERT INTO MenuItem VALUES ("Sausage Pizza",             9, "Dairy, Egg, Wheat, Yeast",          "No",  "No",     "Entree");
INSERT INTO MenuItem VALUES ("Gluten Free Cheese Pizza", 11, "Dairy, Egg, Soy",                  "Yes", "Yes",     "Entree");
INSERT INTO MenuItem VALUES ("Steak",                    16, "Dairy",                             "No", "Yes",     "Entree");
INSERT INTO MenuItem VALUES ("Bean Burrito",              7, "Wheat, Soy, Dairy, Legume",        "Yes",  "No",     "Entree");
INSERT INTO MenuItem VALUES ("Spaghetti",                14, "Wheat, Gluten, Dairy, Egg, Tomato", "No",  "No",     "Entree");
INSERT INTO MenuItem VALUES ("Chicken Tenders",           7, "Wheat, Soy, Egg, Dairy, Gluten",    "No",  "No",     "Entree");
INSERT INTO MenuItem VALUES ("Fries",           		  3, "Wheat, Soy, Egg, Dairy",           "Yes",  "No",       "Side");
INSERT INTO MenuItem VALUES ("Chips",           		  2, "Wheat, Soy, Egg, Dairy",           "Yes",  "No",       "Side");
INSERT INTO MenuItem VALUES ("Tomato Soup",               4, "Tomato, Dairy",            	    "Yes",  "Yes",       "Side");
INSERT INTO MenuItem VALUES ("Crackers",                  0, "Wheat, Gluten",            		 "Yes",  "No",       "Side");
INSERT INTO MenuItem VALUES ("Chicken Noodle Soup",       4, "Wheat, Gluten, Egg, Dairy",         "No",  "No",       "Side");
INSERT INTO MenuItem VALUES ("Fountain Drink",            2, "",          					    "Yes",  "Yes",      "Drink");
INSERT INTO MenuItem VALUES ("Shake",     			      5, "Dairy, Gluten, Nuts",              "Yes",  "No",      "Drink");
INSERT INTO MenuItem VALUES ("Water Cup",           	  0, "",          				        "Yes",  "Yes",      "Drink");
INSERT INTO MenuItem VALUES ("Bottled Water",             2, "",          				        "Yes",  "Yes",      "Drink");
INSERT INTO MenuItem VALUES ("Apple Juice",           	  2, "",          					    "Yes",  "Yes",      "Drink");
INSERT INTO MenuItem VALUES ("Coffee",           	      3, "",          					    "Yes",  "Yes",      "Drink");
INSERT INTO MenuItem VALUES ("Orange Juice",           	  2, "",          					    "Yes",  "Yes",      "Drink");
INSERT INTO MenuItem VALUES ("Brownie",           		  3, "Wheat, Egg, Dairy, Gluten",        "Yes",  "No",    "Dessert");
INSERT INTO MenuItem VALUES ("Chocolate Chip Cookie",     3, "Wheat, Egg, Dairy, Gluten",        "Yes",  "No",    "Dessert");
INSERT INTO MenuItem VALUES ("Cheesecake",          	  5, "Wheat, Dairy, Gluten",             "Yes",  "No",    "Dessert");

INSERT INTO CustomerOrder VALUES ("111222333", "Salad",                    101, 2);
INSERT INTO CustomerOrder VALUES ("111222333", "Hamburger",                102, 1);
INSERT INTO CustomerOrder VALUES ("197355426", "Pepperoni Pizza",          103, 3);
INSERT INTO CustomerOrder VALUES ("222222222", "Chicken Tenders",          104, 5);
INSERT INTO CustomerOrder VALUES ("772655819", "Gluten Free Cheese Pizza", 105, 1);
INSERT INTO CustomerOrder VALUES ("444444444", "Spaghetti",                106, 2);
INSERT INTO CustomerOrder VALUES ("629354882", "Hamburger",                107, 3);
INSERT INTO CustomerOrder VALUES ("111111112", "Spaghetti",                108, 1);
INSERT INTO CustomerOrder VALUES ("111111113", "Pepperoni Pizza",          109, 4);
INSERT INTO CustomerOrder VALUES ("111111113", "Pepperoni Pizza",          110, 1);

INSERT INTO Ticket VALUES ( 1, "2024-11-1", 101);
INSERT INTO Ticket VALUES ( 2, "2024-11-1", 102);
INSERT INTO Ticket VALUES ( 3, "2024-11-1", 103);
INSERT INTO Ticket VALUES ( 4, "2024-11-1", 104);
INSERT INTO Ticket VALUES ( 5, "2024-11-2", 105);
INSERT INTO Ticket VALUES ( 6, "2024-11-2", 106);
INSERT INTO Ticket VALUES ( 7, "2024-11-3", 107);
INSERT INTO Ticket VALUES ( 8, "2024-11-3", 108);
INSERT INTO Ticket VALUES ( 9, "2024-11-3", 109);
INSERT INTO Ticket VALUES (10, "2024-11-3", 110);

INSERT INTO Inventory VALUES ("Lettuce",                 200, "Salad, Hamburger",                                                                  "555555555");
INSERT INTO Inventory VALUES ("Cucumber",                100, "Salad",                                                                             "555555555");
INSERT INTO Inventory VALUES ("Carrot",                  100, "Salad, Chicken Noodle Soup",                                                        "555555555");
INSERT INTO Inventory VALUES ("Tomato",                  200, "Salad, Hamburger",                                                                  "555555555");
INSERT INTO Inventory VALUES ("Beef Patty",              400, "Hamburger",                                                                         "449620351");
INSERT INTO Inventory VALUES ("Hamburger Bun",           300, "Hamburger",                                                                         "112255438");
INSERT INTO Inventory VALUES ("Onion",                   500, "Hamburger, Chicken Noodle Soup",                                                    "832556974");
INSERT INTO Inventory VALUES ("Pizza Dough",             500, "Cheese Pizza, Pepperoni Pizza, Sausage Pizza",                                      "112255438");
INSERT INTO Inventory VALUES ("Cheese",                  400, "Cheese Pizza, Pepperoni Pizza, Sausage Pizza",                                      "670547720");
INSERT INTO Inventory VALUES ("Vegan Cheese",            300, "Gluten Free Cheese Pizza",                                                          "670547720");
INSERT INTO Inventory VALUES ("Tomato Sauce",            600, "Cheese Pizza, Pepperoni Pizza, Sausage Pizza, Gluten Free Cheese Pizza, Spaghetti", "926374289");
INSERT INTO Inventory VALUES ("Pepperoni",               200, "Pepperoni Pizza",                                                                   "449620351");
INSERT INTO Inventory VALUES ("Sausage",                  75, "Sausage Pizza, Spaghetti",                                                          "449620351");
INSERT INTO Inventory VALUES ("Gluten Free Pizza Dough", 200, "Gluten Free Cheese Pizza",                                                          "112255438");
INSERT INTO Inventory VALUES ("Steak",                   400, "Steak",                                                                             "449620351");
INSERT INTO Inventory VALUES ("Garlic",                  400, "Steak",                                                                             "832556974");
INSERT INTO Inventory VALUES ("Rice",                    150, "Bean Burrito",                                                                      "926374289");
INSERT INTO Inventory VALUES ("Cilantro",                100, "Bean Burrito",                                                                      "832556974");
INSERT INTO Inventory VALUES ("Corn Tortilla",           300, "Bean Burrito",                                                                      "112255438");
INSERT INTO Inventory VALUES ("Beans",                   300, "Bean Burrito",                                                                      "112255438");
INSERT INTO Inventory VALUES ("Pasta",                   300, "Spaghetti, Chicken Noodle Soup",                                                    "135797531");
INSERT INTO Inventory VALUES ("Chicken Tenderloin",      900, "Chicken Tenders, Chicken Noodle Soup",                                              "449620351");
INSERT INTO Inventory VALUES ("Batter",                  600, "Chicken Tenders",                                                                   "112255438");
INSERT INTO Inventory VALUES ("Potato",                  100, "Fries, Chips",                                                                      "112255438");
INSERT INTO Inventory VALUES ("Crackers",                200, "Crackers",                                                                  		   "112255438");
INSERT INTO Inventory VALUES ("Chicken Broth",            50, "Chicken Noodle Soup",                                                               "112255438");
INSERT INTO Inventory VALUES ("Cups",                  	 900, "Fountain Drink, Water Cup, Shake, Coffee",                                          "112255438");
INSERT INTO Inventory VALUES ("Lids",                  	 900, "Fountain Drink, Water Cup, Shake, Coffee",                                          "112255438");
INSERT INTO Inventory VALUES ("Straws",                  900, "Fountain Drink, Water Cup, Shake",                                                  "112255438");
INSERT INTO Inventory VALUES ("Ketchup Packet",          900, "Hamburger",                                                         				   "112255438");
INSERT INTO Inventory VALUES ("Mustard Packet",          900, "Hamburger",                                                                         "112255438");
INSERT INTO Inventory VALUES ("Mayo Packet",             900, "Hamburger",                                                                         "112255438");
INSERT INTO Inventory VALUES ("Hot Sauce Packet",        900, "Bean Burrito",                                                                      "112255438");
INSERT INTO Inventory VALUES ("Cream",                   100, "Tomato Soup, Shake",                                                                "112255438");
INSERT INTO Inventory VALUES ("Apple Juice Box",         100, "Apple Juice",                                                                       "112255438");
INSERT INTO Inventory VALUES ("Orange Juice Box",        100, "Orange Juice",                                                                      "112255438");
INSERT INTO Inventory VALUES ("Bottled Waters",           100, "Bottled Water",                                                                    "112255438");
INSERT INTO Inventory VALUES ("Coffee Packet",           100, "Coffee",                                                                            "112255438");
INSERT INTO Inventory VALUES ("Brownie",                  50, "Brownie",                                                                           "112255438");
INSERT INTO Inventory VALUES ("Cookie",                   50, "Chocolate Chip Cookie",                                                             "112255438");
INSERT INTO Inventory VALUES ("Cheesecake",               50, "Cheesecake",                                                                        "112255438");
INSERT INTO Inventory VALUES ("Strawberry Syrup",        350, "Shake",                                                                             "112255438");
INSERT INTO Inventory VALUES ("Chocolate Syrup",         350, "Shake",                                                                             "112255438");
INSERT INTO Inventory VALUES ("Oreo Crumbles",           350, "Shake",                                                                             "112255438");

INSERT INTO MenuIngredientUsage VALUES ("Salad",                                    "Lettuce", 4);
INSERT INTO MenuIngredientUsage VALUES ("Salad",                                   "Cucumber", 1);
INSERT INTO MenuIngredientUsage VALUES ("Salad",                                     "Carrot", 1);
INSERT INTO MenuIngredientUsage VALUES ("Salad",                                     "Tomato", 2);
INSERT INTO MenuIngredientUsage VALUES ("Hamburger",                                "Lettuce", 2);
INSERT INTO MenuIngredientUsage VALUES ("Hamburger",                                 "Tomato", 1);
INSERT INTO MenuIngredientUsage VALUES ("Hamburger",                             "Beef Patty", 1);
INSERT INTO MenuIngredientUsage VALUES ("Hamburger",                          "Hamburger Bun", 2);
INSERT INTO MenuIngredientUsage VALUES ("Hamburger",                                  "Onion", 1);
INSERT INTO MenuIngredientUsage VALUES ("Hamburger",                         "Ketchup Packet", 1);
INSERT INTO MenuIngredientUsage VALUES ("Hamburger",                         "Mustard Packet", 1);
INSERT INTO MenuIngredientUsage VALUES ("Hamburger",                            "Mayo Packet", 1);
INSERT INTO MenuIngredientUsage VALUES ("Cheese Pizza",                         "Pizza Dough", 1);
INSERT INTO MenuIngredientUsage VALUES ("Cheese Pizza",                              "Cheese", 3);
INSERT INTO MenuIngredientUsage VALUES ("Cheese Pizza",                        "Tomato Sauce", 3);
INSERT INTO MenuIngredientUsage VALUES ("Pepperoni Pizza",                      "Pizza Dough", 1);
INSERT INTO MenuIngredientUsage VALUES ("Pepperoni Pizza",                           "Cheese", 3);
INSERT INTO MenuIngredientUsage VALUES ("Pepperoni Pizza",                     "Tomato Sauce", 3);
INSERT INTO MenuIngredientUsage VALUES ("Pepperoni Pizza",                        "Pepperoni", 3);
INSERT INTO MenuIngredientUsage VALUES ("Sausage Pizza",                        "Pizza Dough", 1);
INSERT INTO MenuIngredientUsage VALUES ("Sausage Pizza",                             "Cheese", 3);
INSERT INTO MenuIngredientUsage VALUES ("Sausage Pizza",                       "Tomato Sauce", 3);
INSERT INTO MenuIngredientUsage VALUES ("Sausage Pizza",                            "Sausage", 3);
INSERT INTO MenuIngredientUsage VALUES ("Gluten Free Cheese Pizza",            "Vegan Cheese", 3);
INSERT INTO MenuIngredientUsage VALUES ("Gluten Free Cheese Pizza",            "Tomato Sauce", 3);
INSERT INTO MenuIngredientUsage VALUES ("Gluten Free Cheese Pizza", "Gluten Free Pizza Dough", 1);
INSERT INTO MenuIngredientUsage VALUES ("Steak",                                      "Steak", 1);
INSERT INTO MenuIngredientUsage VALUES ("Steak",                                     "Garlic", 2);
INSERT INTO MenuIngredientUsage VALUES ("Bean Burrito",                                "Rice", 2);
INSERT INTO MenuIngredientUsage VALUES ("Bean Burrito",                            "Cilantro", 1);
INSERT INTO MenuIngredientUsage VALUES ("Bean Burrito",                       "Corn Tortilla", 2);
INSERT INTO MenuIngredientUsage VALUES ("Bean Burrito",                               "Beans", 1);
INSERT INTO MenuIngredientUsage VALUES ("Bean Burrito",                    "Hot Sauce Packet", 2);
INSERT INTO MenuIngredientUsage VALUES ("Spaghetti",                           "Tomato Sauce", 3);
INSERT INTO MenuIngredientUsage VALUES ("Spaghetti",                                  "Pasta", 4);
INSERT INTO MenuIngredientUsage VALUES ("Spaghetti",                                "Sausage", 4);
INSERT INTO MenuIngredientUsage VALUES ("Chicken Tenders",               "Chicken Tenderloin", 3);
INSERT INTO MenuIngredientUsage VALUES ("Chicken Tenders",                           "Batter", 3);
INSERT INTO MenuIngredientUsage VALUES ("Fries",                           		     "Potato", 1);
INSERT INTO MenuIngredientUsage VALUES ("Chips",                                     "Potato", 1);
INSERT INTO MenuIngredientUsage VALUES ("Tomato Soup",                               "Tomato", 3);
INSERT INTO MenuIngredientUsage VALUES ("Chicken Noodle Soup",           "Chicken Tenderloin", 1);
INSERT INTO MenuIngredientUsage VALUES ("Chicken Noodle Soup",                "Chicken Broth", 1);
INSERT INTO MenuIngredientUsage VALUES ("Chicken Noodle Soup",                        "Pasta", 2);
INSERT INTO MenuIngredientUsage VALUES ("Chicken Noodle Soup",                       "Carrot", 1);
INSERT INTO MenuIngredientUsage VALUES ("Chicken Noodle Soup",                        "Onion", 1);
INSERT INTO MenuIngredientUsage VALUES ("Fountian Drink",                              "Cups", 1);
INSERT INTO MenuIngredientUsage VALUES ("Fountain Drink",                              "Lids", 1);
INSERT INTO MenuIngredientUsage VALUES ("Fountain Drink",                            "Straws", 1);
INSERT INTO MenuIngredientUsage VALUES ("Water Cup",                                   "Cups", 1);
INSERT INTO MenuIngredientUsage VALUES ("Water Cup",                                   "Lids", 1);
INSERT INTO MenuIngredientUsage VALUES ("Water Cup",                                 "Straws", 1);
INSERT INTO MenuIngredientUsage VALUES ("Shake",                                       "Cups", 1);
INSERT INTO MenuIngredientUsage VALUES ("Shake",                                       "Lids", 1);
INSERT INTO MenuIngredientUsage VALUES ("Shake",                                     "Straws", 1);
INSERT INTO MenuIngredientUsage VALUES ("Shake",                                      "Cream", 3);
INSERT INTO MenuIngredientUsage VALUES ("Brownie",                                  "Brownie", 1);
INSERT INTO MenuIngredientUsage VALUES ("Chocolate Chip Cookie",                     "Cookie", 1);
INSERT INTO MenuIngredientUsage VALUES ("Cheesecake",                            "Cheesecake", 1);
INSERT INTO MenuIngredientUsage VALUES ("Apple Juice",                      "Apple Juice Box", 1);
INSERT INTO MenuIngredientUsage VALUES ("Orange Juice",                    "Orange Juice Box", 1);
INSERT INTO MenuIngredientUsage VALUES ("Bottled Water",                     "Bottled Waters", 1);
INSERT INTO MenuIngredientUsage VALUES ("Coffee",                             "Coffee Packet", 1);
INSERT INTO MenuIngredientUsage VALUES ("Coffee",                                      "Cups", 1);
INSERT INTO MenuIngredientUsage VALUES ("Coffee",                                      "Lids", 1);


/* Ingredients Add/Remove */
	-- INSERT INTO Inventory VALUES ([varchar of ingredient name], quantity, [varchar of menu items ingredient is in, separated by a commas and spaces], [ssn of manager who is in charge of ingredient stock]);
		-- INSERT INTO Inventory VALUES ("Lettuce", 200, "Salad, Hamburger", "555555555");
    -- DELETE FROM Inventory WHERE ingredientName = [ingredient name that it was inserted with];
		-- ex: DELETE FROM Inventory WHERE ingredientName = "Lettuce";
			-- NOTE: This impacts MenuIngredientUsage (currently set to delete/update depending on what action was taken)

/* Update Ingredient Quantities */
	-- UPDATE Inventory SET ingredientQuantity = ingredientQuantity + [int amount you want the quanity to be] WHERE ingredientName = [ingredient name that you want to update];
		-- ex: UPDATE Inventory SET ingredientQuantity = ingredientQuantity + 1 WHERE ingredientName = "Lettuce";
			-- This is the same for both adding/removing
	-- UPDATE Inventory SET ingredientQuantity = ingredientQuantity - (SELECT ingredientAmntUsed FROM MenuIngredientUsage WHERE inventoryIngredientName = "Lettuce" and menuItemName = [food name] LIMIT 1) WHERE ingredientName = [ingredient name];
        -- ex: UPDATE Inventory SET ingredientQuantity = ingredientQuantity - (SELECT ingredientAmntUsed FROM MenuIngredientUsage WHERE inventoryIngredientName = "Lettuce" and menuItemName = "Hamburger" LIMIT 1) WHERE ingredientName = "Lettuce";
			-- this is for removing based on using the ingredient in a menu item. don't ask me how this works, it just does. and yes, the inventoryIngredientName needs to be in both places (inside becuase it'll use wrong value otherwise, outside because it gives error about safe mode modifying)
