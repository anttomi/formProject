import React, { useState, useEffect } from 'react';
import * as Survey from "survey-react";
import "survey-react/survey.css";


function Form() {

    const [question, setQuestion] = useState({title: "", type: "", choices: ([])});
    const [answer, setAnswer] = useState()
    const [complete, setComplete] = useState(false)


    const fetchQuestion = () => {
      fetch('https://formproject6.herokuapp.com/questions')
      .then(response => response.json())
      .then(data => { json += "questions: ["
        json += data
        json += "]"
        
  },
  console.log(json));

      }
    
  let json = {
    
    }

    const onComplete = () => {
        setComplete (true);
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
   return(
       <div>
        {surveyRender}
        {completed}
       <button onClick={fetchQuestion}>LOL</button>
       </div>
   );
}

export default Form;