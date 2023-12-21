# Cohort 3 Regression Tests

- Java Warriors -> Cyclones
- Cylcones -> CNN6
- CNN6 -> Java Warriors
- Hocus Pocus -> Hocus Pocus
- Pro.To.Type -> Pro.To.Type
- BReaking COde -> BReaking COde


## Change or Add Environment

Confirm that your teams' Environmental variables are correct and add other teams' Environmental Variables to your Machine.
Set up the teams' database (If applicable)

How do you access Environmental variables? 
1. Open Control Panel > System and Security > System > Advanced system settings. OR Search for "Environmental Variables" in the search bar at the bottom.
2. Click Environment Variables.
4. Click New under "System variables". Define Variable name and Variable value.
6. Add all of the following values to your Environment. (Again make sure to exclude your teams' variables since you probably already have those):

    * name: ```auth_db_user```
    * name: ```auth_db_pass```
    * name: ```JavaWarriorsUser``` 
    * name: ```JavaWarriors```
    * name: ```rules_engine_username```
    * name: ```rules_engine_password``` 
    * name: ```simulations_username```
    * name: ```simulation_password``` 

7. Run ```docker compose up``` to execute the compose file.
