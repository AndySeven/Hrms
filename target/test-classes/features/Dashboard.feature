# Author: your.email@your.domain.com

Feature: Dashboard
Scenario: Dashboard menu view for admin

# This When already exists in other feature
When user is logged in with valid admin credentials
Then user sees dashboard menu is displayed

|Admin|PIM|Leave|Time|Recruitment|Performance|Dashboard|Directory|

And user sees dashboard menu is displayed step by step

|Admin|PIM|Leave|Time|Recruitment|Performance|Dashboard|Directory|