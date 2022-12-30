import axios from 'axios'
import { Button, Radio } from 'antd';
import { useState, useEffect } from 'react';

import { getStudents, addNewStudent } from "../api/ApiEndpoints"

const Students = () => {
    const [students, setStudents] = useState([]);

    useEffect(() => {
        console.log("component is mounted");
        setStudents(getStudents)
        // getStudents();
        return () => {

        };

    }, [])

  return (
    <div>
      <Button type='primary'>{students.length}</Button>
      <br />
      <Radio.Group value='large' >
        <Radio.Button value="large">Large</Radio.Button>
        <Radio.Button value="default">Default</Radio.Button>
        <Radio.Button value="small">Small</Radio.Button>
      </Radio.Group>
      <br/>
      <p>{students.length}</p>

        {
            students.length >= 0 ? 
            students.map((student, index) => <p key={index}>{student.id}. {student.name}</p>)
            : <p>No data</p>
        }
    </div>
  )
}

export default Students