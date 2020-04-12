# MovieTime

## About

Hristijan Davinovski 161061
Web Programming - Faculty of Computer Science and Engeneering, Skopje

## Description of the application

MovieTime time is an application that helps find all the latest movies. All you need to do is just create an account and then
you can search by movie title and sort all the movies by title, rating or year. Moreover, to find a movie without 
going through all the movies, you can filter movies by movie genres. You can post a comment, rate the movie or 
add it to your favourites. If you're logged in as admin, you can add, edit and delete movies and stars and see all the stats
for the movies which are posted on the app.

## Starting the application

### Back-end
To connect to the database, you need to create a database with:  <br/>
**name**: proektWP  <br/>
**user**: postgres  <br/>
**password**: admin  <br/>

You can find these in the **application.properties**.  <br/>
Once you have the database, run the **mk.ukim.finki.seminarska.SeminarskaApplication class** and then you will find all the tables
in the database created and populated (mk.ukim.finki.seminarska.Initializer.DataLoader).

Two users are already created in the database: <br/>
**username**: admin@admin.com  <br/>
**password**: 12345  <br/>
with role - admin.  <br/>

**username**: user@user.com <br/>
**password**: 12345  <br/>
with role - user.  <br/>

But, if you want you can also register another user. 

### Front-end

Open terminal and then run:

```javascript
npm install
npm start
```
The app is running on http://localhost:3000.
