import React, { useEffect, useState } from 'react';
import Text from "./components/Text"
import {Button} from "@material-ui/core"


function Form() {
  /**
  const [question, setQuestion] = useState({id: null, title: "", type: "", choices: ([]) });
  const [answer, setAnswer] = useState()
   */
  const [complete, setComplete] = useState(false)
  const [json, setJson] = useState({questions: []})
  const [answer, setAnswer] = React.useState({question: {questionid: 3}, input: ''})
  const [answers, setAnswers] = React.useState([])
  const [questions, setQuestions] = useState([])
     
  useEffect (() => {
    fetchQuestion();


    },[])

  const saveAnswer = async () => {
    console.log(answer)

    await fetch('http://localhost:8080/answers',
    {
      method: 'POST',
      body: JSON.stringify(answer),
      headers: { 'Content-type' : 'application/json'  }
    })
    //.then(_ => fetchQuestion())
    .catch(err => console.error(err))
  }

  const inputChanged = (event) => {
    setAnswer({ ...answer, [event.target.name]: event.target.value });
  }

  
  
  const fetchQuestion = () => {
    
    fetch('http://localhost:8080/questions')
      .then(response => response.json())
      .then(data => {
        let jsonQ = {
          questions: [
           ]
        }
        let i = 0;
        while (i < data.length) {
          jsonQ.questions[i] = {
            id: data[i].id,
            type: data[i].type,
            name: String(i),
            title: data[i].title,
            choices: data[i].choices
          }
          
          i++; 
          
        }
        setJson(jsonQ)
      }
      )
      .catch(err => console.error(err))
  }

  
  let createForm = () => {
    let html = <div></div>
    for (let i = 0; i < json.length; i++) {
      html += <Text title={json.questions[i].title}/>

    }
    return html
  }
 
  const onComplete = () => {
    setComplete(true);
    saveAnswer();
    
  }

  

  return (
    <form id="quiz" onSubmit={onComplete}>
      <Text title="joo" id="1"></Text>
      <Button></Button>
    </form>
  );
}

export default Form;