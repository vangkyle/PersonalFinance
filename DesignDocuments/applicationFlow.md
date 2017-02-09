# Application Flow

### User Sign Up
1. User chooses sign up on the menu links (available on all pages, unless the user 
   is signed in already).
1. User fills out the sign up form and submits.
1. Request goes to sign up servlet.
1. Servlet creates a user object and then creates user in the database.
1. Response to user confirming addition (show a message on the jsp)

### User Sign In
1. User chooses sign in on the menu (available on all pages, unless the user 
is signed in already).
1. User enters username and password on form and submits. 
1. If user is authenticated, the server will handle allowing access to edit 
pages.  JDBCRealm used for authentication (users, users_roles, and roles table).
1. If authentication fails, show error message/page.

### Dash Board
1. Page sends a request to view expense reports servlet.
1. Dao performs select and creates reports objects from results.
1. Dao returns list of reports to servlet.
1. Servlet sends list back to dash board jsp.
1. Dash board jsp displays the expense report with graph.

### Expense Entry
1. Option only available to logged in users with proper role.
1. User enters expenses to form on jsp.
1. If entry is valid then user entry is sent to database to be stored.
1. Return message for entry conformation.

