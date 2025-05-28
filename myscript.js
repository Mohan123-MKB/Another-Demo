function showCourses(){

    fetch("http://localhost:8080/courses")//api end point GET request pothu
    .then((response) =>response.json()) 
    // it give all data(available course) from database,if any request is comes from frontend for need data then controller accept request from server @GetMapping method helps to display data(in the form of JSON) to clients from database through this process doing by spring boot.
    //this is json courses[inside lot of course objects or data]
    // Below foreach loop is JSON file will be course each object is in line format in table and $ doller is repersent course varaible la irunthu varathunala podanum so json object is convert into each row in tables
    .then((courses) => {
        const datatable=document.getElementById("courseTable")
        courses.forEach(course => {
            var row= `<tr>
            <td>${course.courseId}</td>  
            <td>${course.courseName}</td>
            <td>${course.trainer}</td>
            <td>${course.durationInWeeks}</td>
           </tr>`
           datatable.innerHTML+=row; //html kula html varanum na innerHTML
        });
    });
}

function showEnrolledStudents(){
    
    fetch("http://localhost:8080/courses/enrolled")//api end point GET request pothu
    .then((response) =>response.json()) //http response into json abject
    // it give all data(available course) from database,if any request is comes from frontend for need data then controller accept request from server @GetMapping method helps to display data(in the form of JSON) to clients from database through this process doing by spring boot.
    //this is json courses[inside lot of course objects or data]
    // Below foreach loop is JSON file will be course each object is in line format in table and $ doller is repersent course varaible la irunthu varathunala podanum so json object is convert into each row in tables
    .then((students) => {
        const datatable=document.getElementById("enrolledTable")
        students.forEach(student => {
            var row= `<tr>
            <td>${student.name}</td>  
            <td>${student.emailId}</td>
            <td>${student.courseName}</td>
           </tr>`
           datatable.innerHTML+=row; //html kula html varanum na innerHTML
        });
    });

}