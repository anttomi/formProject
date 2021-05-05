import React, { useEffect, useState } from 'react';
import * as Survey from "survey-react";
import "survey-react/survey.css";


function Form() {
  /**
  const [question, setQuestion] = useState({id: null, title: "", type: "", choices: ([]) });
  const [answer, setAnswer] = useState()
   */
  const [complete, setComplete] = useState(false)
  const [json, setJson] = useState({questions: []})
  const [answer, setAnswer] = React.useState({input: 'testi'})
     
  const saveAnswer = async () => {
    console.log(answer)

    await fetch('https://formproject6.herokuapp.com/answers',
    {
      method: 'POST',
      body: JSON.stringify(answer),
      headers: { 'Content-type' : 'application/json'  }
    })
    //.then(_ => fetchQuestion())
    .catch(err => console.error(err))
  }

  useEffect (() => {

    fetchQuestion();

    },[])
  
  const fetchQuestion = () => {
    
    fetch('https://formproject6.herokuapp.com/questions')
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

  console.log(json)


  const onComplete = () => {
    setComplete(true);
    saveAnswer();
  }

  var surveyRender = !complete ? (
    <Survey.Survey
      json={json}
      onComplete={onComplete}

    />

  ) : null
  var completed = complete ? (
    <div>Vastasit kaikkiin pakollisiin kysymyksiin. Kiitos</div>
  ) : null;
  return (
    <div>
      {surveyRender}
      {completed}
    </div>
  );
}

export default Form;