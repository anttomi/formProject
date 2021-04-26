import React, { useEffect, useState } from 'react';
import * as Survey from "survey-react";
import "survey-react/survey.css";


function Form() {
  /**
  const [question, setQuestion] = useState({id: null, title: "", type: "", choices: ([]) });
  const [answer, setAnswer] = useState()
   */
  const [complete, setComplete] = useState(false)
     
  let json = {
    questions: [
     ]
  }

  const fetchQuestion = () => {
    fetch('https://formproject6.herokuapp.com/questions')
      .then(response => response.json())
      .then(data => {
        let i = 0;
        while (i < data.length) {
          json.questions[i] = {
            id: data[i].id,
            type: data[i].type,
            title: data[i].title,
            choices: data[i].choices
          }
          i++;
          
        }
      }
      )
      .catch(err => console.error(err))
  }

  useEffect (() => {

    fetchQuestion();

    },[])
  

  const onComplete = () => {
    setComplete(true);
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