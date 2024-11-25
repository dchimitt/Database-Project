CREATE DATABASE pointOfSale;
USE pointOfSale;

CREATE TABLE Employee (
  ssn  char(9),
  fname  varchar(15) not null,
  lname varchar(15) not null,
  daysWorked varchar(13), -- Days an employee can work
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



INSERT INTO Employee VALUES ("123456789", "Michael",   "Carter", "M, T, W, R, F",        null, true);
INSERT INTO Employee VALUES ("112255438", "Kimberly",    "Gray", "M, T, W, R, F",        null, true);
INSERT INTO Employee VALUES ("135797531", "Elizabeth", "Nelson", "M, T, W, R, F",        null, true);
INSERT INTO Employee VALUES ("246864246", "Richard",    "James", "M, T, W, R, F",        null, true);
INSERT INTO Employee VALUES ("763234551", "James",      "Myers", "M, T, W, R, F",        null, true);
INSERT INTO Employee VALUES ("555555555", "Ruth",      "Thomas", "M, T, W, R, F",        null, true);
INSERT INTO Employee VALUES ("926374289", "Sarah",     "Wilson", "M, T, W, R, F",        null, true);
INSERT INTO Employee VALUES ("832556974", "James",     "Miller", "M, T, W, R, F",        null, true);
INSERT INTO Employee VALUES ("449620351", "Emerson",   "Miller", "M, T, W, R, F",        null, true);
INSERT INTO Employee VALUES ("670547720", "Taylor",   "Roberts", "M, T, W, R, F",        null, true);
INSERT INTO Employee VALUES ("111222333", "Robert",      "Ross", "M, T, W, R, F", "123456789", true);
INSERT INTO Employee VALUES ("197355426", "Ryan",       "Moore", "M, W, F",       "112255438", true);
INSERT INTO Employee VALUES ("222222222", "William",   "Parker", "M, T, W, R, F", "135797531", true);
INSERT INTO Employee VALUES ("772655819", "Maria",     "Butler", "M, W, R, F",    "246864246", true);
INSERT INTO Employee VALUES ("444444444", "Lisa",      "Harris", "M, T, W, R, F", "763234551", true);
INSERT INTO Employee VALUES ("629354882", "Joseph",    "Turner", "M, T, R, F",    "555555555", true);
INSERT INTO Employee VALUES ("111111112", "Annabeth",  "Garcia", "M, T, W, R, F", "926374289", true);
INSERT INTO Employee VALUES ("111111113", "Richard",  "Collins", "M, T, W, R, F", "832556974", true);
INSERT INTO Employee VALUES ("335336337", "Lillian",    "Perry", "M, T, W, R, F", "449620351", true);
INSERT INTO Employee VALUES ("599431111", "Michael",     "Gray", "M, T, R, F",    "670547720", true);
INSERT INTO Employee VALUES ("499622555", "Margaret", "Roberts", "M, T, W, R, F", "123456789", true);
INSERT INTO Employee VALUES ("763333318", "Brian",       "Cook", "M, T, W, R, F", "112255438", true);
INSERT INTO Employee VALUES ("888899991", "Teresa",    "Howard", "M, T, W, R, F", "135797531", true);
INSERT INTO Employee VALUES ("283664357", "Jessica",     "Ross", "M, T, W, R, F", "123456789", true);
INSERT INTO Employee VALUES ("888888888", "Lisa",    "Thompson", "M, T, W, R, F", "112255438", true);
INSERT INTO Employee VALUES ("987654321", "David", "Richardson", "M, T, W, R, F", "135797531", true);
INSERT INTO Employee VALUES ("975322164", "Mary",       "Jones", "T, W, R, F",    "926374289", true);
INSERT INTO Employee VALUES ("777333444", "Jordan",    "Miller", "M, T, W, R, F", "832556974", true);
INSERT INTO Employee VALUES ("777999000", "Tristan",   "Graham", "M, T, W, R, F", "449620351", true);
INSERT INTO Employee VALUES ("777462111", "Taylor",    "Bryant", "M, T, W, R",    "670547720", true);

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

INSERT INTO MenuItem VALUES ("Salad",                     6, "Tomato",                           "Yes",  "No");
INSERT INTO MenuItem VALUES ("Hamburger",                11, "Wheat, Soy, Yeast, Tomato",         "No",  "No");
INSERT INTO MenuItem VALUES ("Cheese Pizza",              8, "Dairy, Egg, Wheat, Yeast, Tomato", "Yes",  "No");
INSERT INTO MenuItem VALUES ("Pepperoni Pizza",           9, "Dairy, Egg, Wheat, Yeast",          "No",  "No");
INSERT INTO MenuItem VALUES ("Sausage Pizza",             9, "Dairy, Egg, Wheat, Yeast",          "No",  "No");
INSERT INTO MenuItem VALUES ("Gluten Free Cheese Pizza", 11, "Dairy, Egg, Soy",                  "Yes", "Yes");
INSERT INTO MenuItem VALUES ("Steak",                    16, "Dairy",                             "No", "Yes");
INSERT INTO MenuItem VALUES ("Bean Burrito",              7, "Wheat, Soy, Dairy, Legume",        "Yes",  "No");
INSERT INTO MenuItem VALUES ("Spaghetti",                14, "Wheat, Gluten, Dairy, Egg, Tomato", "No",  "No");
INSERT INTO MenuItem VALUES ("Chicken Tenders",           7, "Wheat, Soy, Egg, Dairy",            "No",  "No");

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
INSERT INTO Inventory VALUES ("Carrot",                  100, "Salad",                                                                             "555555555");
INSERT INTO Inventory VALUES ("Tomato",                  200, "Salad, Hamburger",                                                                  "555555555");
INSERT INTO Inventory VALUES ("Ground Beef",             400, "Hamburger",                                                                         "449620351");
INSERT INTO Inventory VALUES ("Hamburger Bun",           300, "Hamburger",                                                                         "112255438");
INSERT INTO Inventory VALUES ("Onion",                   500, "Hamburger",                                                                         "832556974");
INSERT INTO Inventory VALUES ("Pizza Dough",             500, "Cheese Pizza, Pepperoni Pizza, Sausage Pizza",                                      "112255438");
INSERT INTO Inventory VALUES ("Cheese",                  400, "Cheese Pizza, Pepperoni Pizza, Sausage Pizza",                                      "670547720");
INSERT INTO Inventory VALUES ("Vegan Cheese",            300, "Gluten Free Cheese Pizza",                                                          "670547720");
INSERT INTO Inventory VALUES ("Tomato Sauce",            600, "Cheese Pizza, Pepperoni Pizza, Sausage Pizza, Gluten Free Cheese Pizza, Spaghetti", "926374289");
INSERT INTO Inventory VALUES ("Pepperoni",               200, "Pepperoni Pizza",                                                                   "449620351");
INSERT INTO Inventory VALUES ("Sausage",                  75, "Sausage Pizza",                                                                     "449620351");
INSERT INTO Inventory VALUES ("Gluten Free Pizza Dough", 200, "Gluten Free Cheese Pizza",                                                          "112255438");
INSERT INTO Inventory VALUES ("Steak",                   400, "Steak",                                                                             "449620351");
INSERT INTO Inventory VALUES ("Garlic",                  400, "Steak",                                                                             "832556974");
INSERT INTO Inventory VALUES ("Rice",                    150, "Bean Burrito",                                                                      "926374289");
INSERT INTO Inventory VALUES ("Cilantro",                100, "Bean Burrito",                                                                      "832556974");
INSERT INTO Inventory VALUES ("Corn Tortilla",           300, "Bean Burrito",                                                                      "112255438");
INSERT INTO Inventory VALUES ("Pasta",                   300, "Spaghetti",                                                                         "135797531");
INSERT INTO Inventory VALUES ("Chicken Tenderloin",      600, "Chicken Tenders",                                                                   "449620351");
INSERT INTO Inventory VALUES ("Batter",                  600, "Chicken Tenders",                                                                   "112255438");

INSERT INTO MenuIngredientUsage VALUES ("Salad",                                    "Lettuce", 4);
INSERT INTO MenuIngredientUsage VALUES ("Salad",                                   "Cucumber", 1);
INSERT INTO MenuIngredientUsage VALUES ("Salad",                                     "Carrot", 1);
INSERT INTO MenuIngredientUsage VALUES ("Salad",                                     "Tomato", 2);
INSERT INTO MenuIngredientUsage VALUES ("Hamburger",                                "Lettuce", 2);
INSERT INTO MenuIngredientUsage VALUES ("Hamburger",                                 "Tomato", 1);
INSERT INTO MenuIngredientUsage VALUES ("Hamburger",                            "Ground Beef", 3);
INSERT INTO MenuIngredientUsage VALUES ("Hamburger",                          "Hamburger Bun", 2);
INSERT INTO MenuIngredientUsage VALUES ("Hamburger",                                  "Onion", 1);
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
INSERT INTO MenuIngredientUsage VALUES ("Spaghetti",                           "Tomato Sauce", 3);
INSERT INTO MenuIngredientUsage VALUES ("Spaghetti",                                  "Pasta", 4);
INSERT INTO MenuIngredientUsage VALUES ("Chicken Tenders",               "Chicken Tenderloin", 3);
INSERT INTO MenuIngredientUsage VALUES ("Chicken Tenders",                           "Batter", 3);

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
