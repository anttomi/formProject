import React, { useEffect, useState } from 'react';
import * as Survey from "survey-react";
import "survey-react/survey.css";


function Form() {
  
  const [question, setQuestion] = useState({id: null, title: "", type: "", choices: ([]) });
  const [answer, setAnswer] = useState()
  
  const [complete, setComplete] = useState(false)
 

  useEffect (() => {

    fetchQuestion();
    },[])


  const fetchQuestion = () => {
    fetch('https://formproject6.herokuapp.com/questions')
      .then(response => response.json())
      .then(data => setQuestion({id: data[0].id, title: data[0].title, type: data[0].type, choices: data[0].choices}))
      .catch(err => console.error(err))
  }

  let json = {
    questions: [
      {
        id: question.id,
        type: question.type,
        title: question.title,
        choices: question.choices
      }
     ]
    }

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