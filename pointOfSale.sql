CREATE DATABASE pointOfSale;
USE pointOfSale;

CREATE TABLE Schedule (
  totalHours  integer,
  scheduleID  char(9),
  primary key (scheduleID)
);

CREATE TABLE Employee (
  ssn  char(9),
  fname  varchar(15) not null,
  lname varchar(15) not null,
  daysWorked varchar(21),
  mgrssn char(9),
  primary key (ssn)
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
  orderNum  integer,
  primary key (orderNum),
  foreign key (ssn) references Employee(ssn)
);

CREATE TABLE Ingredient (
  ingredientName  varchar(25),
  numberInInventory  integer,
  primary key (ingredientName)
);

CREATE TABLE Ticket (
  ticketNum integer,
  date date,
  orderNum integer,
  primary key (ticketNum, orderNum),
  foreign key (orderNum) references CustomerOrder (orderNum)
);

INSERT INTO Schedule VALUES (40, "111112345");
INSERT INTO Schedule VALUES (40, "111112346");
INSERT INTO Schedule VALUES (36, "111112347");
INSERT INTO Schedule VALUES (16, "111112348");
INSERT INTO Schedule VALUES ( 8, "111112349");
INSERT INTO Schedule VALUES (24, "111112350");
INSERT INTO Schedule VALUES (40, "111112351");
INSERT INTO Schedule VALUES (40, "111112352");
INSERT INTO Schedule VALUES (32, "111112353");
INSERT INTO Schedule VALUES (20, "111112354");

INSERT INTO Employee VALUES ("123456789", "Michael",   "Carter", "M, T, W, R, F",        null);
INSERT INTO Employee VALUES ("112255438", "Kimberly",    "Gray", "M, T, W, R, F",        null);
INSERT INTO Employee VALUES ("135797531", "Elizabeth", "Nelson", "M, T, W, R, F",        null);
INSERT INTO Employee VALUES ("246864246", "Richard",    "James", "M, T, W, R, F",        null);
INSERT INTO Employee VALUES ("763234551", "James",      "Myers", "M, T, W, R, F",        null);
INSERT INTO Employee VALUES ("555555555", "Ruth",      "Thomas", "M, T, W, R, F",        null);
INSERT INTO Employee VALUES ("926374289", "Sarah",     "Wilson", "M, T, W, R, F",        null);
INSERT INTO Employee VALUES ("832556974", "James",     "Miller", "M, T, W, R, F",        null);
INSERT INTO Employee VALUES ("449620351", "Emerson",   "Miller", "M, T, W, R, F",        null);
INSERT INTO Employee VALUES ("670547720", "Taylor",   "Roberts", "M, T, W, R, F",        null);
INSERT INTO Employee VALUES ("111222333", "Robert",      "Ross", "M, T, W, R, F", "123456789");
INSERT INTO Employee VALUES ("197355426", "Ryan",       "Moore", "M, W, F",       "112255438");
INSERT INTO Employee VALUES ("222222222", "William",   "Parker", "M, T, W, R, F", "135797531");
INSERT INTO Employee VALUES ("772655819", "Maria",     "Butler", "M, W, R, F",    "246864246");
INSERT INTO Employee VALUES ("444444444", "Lisa",      "Harris", "M, T, W, R, F", "763234551");
INSERT INTO Employee VALUES ("629354882", "Joseph",    "Turner", "M, T, R, F",    "555555555");
INSERT INTO Employee VALUES ("111111112", "Annabeth",  "Garcia", "M, T, W, R, F", "926374289");
INSERT INTO Employee VALUES ("111111113", "Richard",  "Collins", "M, T, W, R, F", "832556974");
INSERT INTO Employee VALUES ("335336337", "Lillian",    "Perry", "M, T, W, R, F", "449620351");
INSERT INTO Employee VALUES ("599431111", "Michael",     "Gray", "M, T, R, F",    "670547720");
INSERT INTO Employee VALUES ("499622555", "Margaret", "Roberts", "M, T, W, R, F", "123456789");
INSERT INTO Employee VALUES ("763333318", "Brian",       "Cook", "M, T, W, R, F", "112255438");
INSERT INTO Employee VALUES ("888899991", "Teresa",    "Howard", "M, T, W, R, F", "135797531");
INSERT INTO Employee VALUES ("283664357", "Jessica",     "Ross", "M, T, W, R, F", "123456789");
INSERT INTO Employee VALUES ("888888888", "Lisa",    "Thompson", "M, T, W, R, F", "112255438");
INSERT INTO Employee VALUES ("987654321", "David", "Richardson", "M, T, W, R, F", "135797531");
INSERT INTO Employee VALUES ("975322164", "Mary",       "Jones", "T, W, R, F",    "926374289");
INSERT INTO Employee VALUES ("777333444", "Jordan",    "Miller", "M, T, W, R, F", "832556974");
INSERT INTO Employee VALUES ("777999000", "Tristan",   "Graham", "M, T, W, R, F", "449620351");
INSERT INTO Employee VALUES ("777462111", "Taylor",    "Bryant", "M, T, W, R",    "670547720");

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

INSERT INTO CustomerOrder VALUES ("111222333", 101);
INSERT INTO CustomerOrder VALUES ("111222333", 102);
INSERT INTO CustomerOrder VALUES ("197355426", 103);
INSERT INTO CustomerOrder VALUES ("222222222", 104);
INSERT INTO CustomerOrder VALUES ("772655819", 105);
INSERT INTO CustomerOrder VALUES ("444444444", 106);
INSERT INTO CustomerOrder VALUES ("629354882", 107);
INSERT INTO CustomerOrder VALUES ("111111112", 108);
INSERT INTO CustomerOrder VALUES ("111111113", 109);
INSERT INTO CustomerOrder VALUES ("111111113", 110);

INSERT INTO Ingredient VALUES ("Lettuce",                 200);
INSERT INTO Ingredient VALUES ("Cucumber",                100);
INSERT INTO Ingredient VALUES ("Carrot",                  100);
INSERT INTO Ingredient VALUES ("Tomato",                  200);
INSERT INTO Ingredient VALUES ("Ground Beef",             400);
INSERT INTO Ingredient VALUES ("Hamburger Bun",           300);
INSERT INTO Ingredient VALUES ("Onion",                   500);
INSERT INTO Ingredient VALUES ("Wheat Pizza Dough",       500);
INSERT INTO Ingredient VALUES ("Cheese",                  400);
INSERT INTO Ingredient VALUES ("Vegan Cheese",            300);
INSERT INTO Ingredient VALUES ("Tomato Sauce",            600);
INSERT INTO Ingredient VALUES ("Pepperoni",               200);
INSERT INTO Ingredient VALUES ("Sausage",                  75);
INSERT INTO Ingredient VALUES ("Gluten Free Pizza Dough", 200);
INSERT INTO Ingredient VALUES ("Steak",                   400);
INSERT INTO Ingredient VALUES ("Rice",                    150);
INSERT INTO Ingredient VALUES ("Cilantro",                100);
INSERT INTO Ingredient VALUES ("Corn Tortilla",           300);
INSERT INTO Ingredient VALUES ("Garlic",                  400);
INSERT INTO Ingredient VALUES ("Pasta",                   300);
INSERT INTO Ingredient VALUES ("Chicken Tenderloin",      600);
INSERT INTO Ingredient VALUES ("Batter",                  600);

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