import axios from "axios";

export const getStudents = () => {
    axios.get("api/v1/students")
    .then((data) => data)
    .catch((err) => console.log(err));
} 

export const addNewStudent = () => {
    axios.post("/students/new")
    .then((data) => data)
    .catch(err => err);
}