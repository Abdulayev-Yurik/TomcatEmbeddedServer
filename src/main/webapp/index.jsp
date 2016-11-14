<html>
<head>
    <link rel="stylesheet" href="css/mystyle.css">
</head>
<body>
<form action="/calendar">
    Enter date : <input type="text" name="date" placeholder="enter date 2016-12-30"/><br>
    Enter start week day : <select name="custom_week">
        <option value="1">Monday</option>
        <option value="2">Tuesday</option>
        <option value="3">Wednesday</option>
        <option value="4">Thursday</option>
        <option value="5">Friday</option>
        <option value="6">Saturday</option>
        <option value="7">Sunday</option>
    </select><br>


    Enter weekends :
    <input type="checkbox" name="w" value="1">Monday</input>
    <input type="checkbox" name="w" value="2">Tuesday</input>
    <input type="checkbox" name="w" value="3">Wednesday</input>
    <input type="checkbox" name="w" value="4">Thursday</input>
    <input type="checkbox" name="w" value="5">Friday</input>
    <input checked="true" type="checkbox" name="w" value="6">Saturday</input>
    <input checked="true" type="checkbox" name="w" value="7">Sunday</input>
    <br>
    <input type="submit" value="view calendar"/>
</form>
<form action="/greeter">
    <input type="text" name="name" placeholder="Enter your name"/>
    <input type="submit" class="button" value="Send"></form>
</body>
</html>
