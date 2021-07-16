

Requirements

For this project you must accomplish all of the following:

Create a use case diagram and add it to your README.md. Create a class diagram and add it to your README.md. Create unit tests for every method other than basic getters, setters, and constructors (getters and setters with logic do require unit tests). Handle all exceptions gracefully (incorrect input should not crash the program). Leads can be added to the CRM by typing the command “New Lead” (case insensitive). When a new Lead is created the user will be prompted for name, phoneNumber, email, and companyName. All fields must be supplied to create the new Lead. The system should automatically create an id for the Lead. This may require some research and Googling to accomplish, but is relatively trivial. Your CRM should keep track of how many objects have been created and provide the current count as the id for each new object. A list of all Leads’ id and name can be displayed by typing “Show Leads” (case insensitive). An individual Lead’s details can be displayed by typing “Lookup Lead id” (case insensitive) where “id” is the actual id of the Lead to lookup. A Lead can be converted to an Opportunity by typing “convert id” (case insensitive) where “id” is the actual id of the Lead to convert. When a Lead is converted, a Contact will be created with the Lead contact info and a new id. When a Lead is converted, the user will be prompted for the product and the number of trucks for this Opportunity. A new Opportunity should be created with the above information and with the new Contact as the decisionMaker for the Opportunity and a status of “OPEN”. To recap, Opportunity should have the following properties:

id - a unique identifier

product - an Enum with options HYBRID, FLATBED, or BOX

quantity - the number of trucks being considered for purchase

decisionMaker - a Contact

status - an Enum with options OPEN, CLOSED_WON, CLOSED_LOST (these are common sales terms indicating an ongoing potential sale, a sale, and an opportunity where a sale was not made and the sale is no longer a possibility)

When a Lead is converted, the user will be prompted for the industry, number of employees, city, and country of the organization. An Account represents the company that is looking to buy a truck. Each Account should have a List of Contacts and a List of Opportunities. To recap, the Account should have the following properties:

id - a unique identifier

industry - an Enum with options PRODUCE, ECOMMERCE, MANUFACTURING, MEDICAL, OTHER

employeeCount - a number representing the number of employees in the company

city - a String

country - a String

contactList - a List of Contacts associated with this Account

opportunityList - a list of Opportunities associated with this Account

Leads are removed from the system once they have been successfully converted.

Opportunity status can be edited using the command “close-lost id” or “close-won id” where “id” is the id of the Opportunity that should be closed.

Note: For simplicity, Lead, Account, and Contact information cannot be updated once the object has been created.

Note: For simplicity, there is currently no way to associate multiple Contacts or Opportunities with a single Account. These should still be Lists as we will be adding more functionality to this application in the future.

Important Note.

Everyone in the squad should contribute equally to the project in time and in lines of code written.

All code must be reviewed before it is merged into the master branch.

All squad members must participate in code review.

Code should not be merged into master if it lacks sufficient test coverage.

This is intended to be a challenging assignment. You will have to rely heavily on your teammates and independent research. Learning independently is a hallmark of a good developer and our job is to turn you into good developers. This process may be frustrating but you will learn a ton!
