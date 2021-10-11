import React, { useState, ChangeEvent, useEffect } from 'react';
import api from '../services/api';
import { Form, Button } from 'react-bootstrap';
import './index.css';
import { useHistory } from 'react-router-dom';

interface IAnswer {
  feedback: string;
  score: number;
  survey: { id: number };
}
interface ISurvey {
  id: number;
  question: string;
}

const CreateAnswer: React.FC = () => {
  const history = useHistory();

  const [model, setModel] = useState<IAnswer>({
    feedback: '',
    score: 10,
    survey: { id: 1 },
  });

  const [surveys, setSurveys] = useState<ISurvey[]>([]);

  useEffect(() => {
    getSurveys();
  }, []);

  async function getSurveys() {
    const response = await api.get('/survey');
    setSurveys(response.data);
  }

  function updateModel(e: ChangeEvent<HTMLInputElement>) {
    setModel({
      ...model,
      [e.target.name]: e.target.value,
    });
  }

  async function onSubmit(e: ChangeEvent<HTMLFormElement>) {
    e.preventDefault();
    console.log(JSON.stringify(model));
    await api.post('/answer', model);
    back();
  }

  function back() {
    history.goBack();
  }

  return (
    <div className='"container"'>
      <div className="page-header">
        <h1>New Answer</h1>

        <Button variant="dark" onClick={back}>
          Back
        </Button>
      </div>

      <Form onSubmit={onSubmit}>
        <Form.Group className="mb-3" controlId="formBasicTopic">
          <Form.Label>Select Question</Form.Label>
          <br />{' '}
          <select
            className="custom-select"
            onChange={(e) => {
              console.log(e);
              model.survey.id = Number(e.target.value);
            }}
          >
            {surveys.map((item) => (
              <option key={item.id} value={item.id}>
                {item.question}
              </option>
            ))}
          </select>
        </Form.Group>

        <Form.Group className="mb-3" controlId="formBasicTopic">
          <Form.Label>Give a Score</Form.Label>
          <br />{' '}
          <select
            className="custom-select"
            onChange={(e) => {
              console.log(e.target.value);
              model.score = Number(e.target.value);
            }}
          >
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
          </select>
        </Form.Group>

        <Form.Group className="mb-3" controlId="formBasicQuestion">
          <Form.Label>Feedback</Form.Label>
          <Form.Control
            type="text"
            name="feedback"
            onChange={(e: ChangeEvent<HTMLInputElement>) => updateModel(e)}
            placeholder="Enter Feedback"
            required
          />
        </Form.Group>

        <Button variant="success" type="submit">
          Create
        </Button>
      </Form>
    </div>
  );
};

export default CreateAnswer;
