import React, { useState, ChangeEvent, useEffect } from 'react';
import api from '../services/api';
import { Form, Button } from 'react-bootstrap';
import './index.css';
import { useHistory } from 'react-router-dom';

interface ISurvey {
  question: string;
  topic: { id: number };
}
interface ITopic {
  id: number;
  name: string;
}

const CreateSurvey: React.FC = () => {
  const history = useHistory();

  const [model, setModel] = useState<ISurvey>({
    question: '',
    topic: { id: 1 },
  });

  const [topics, setTopics] = useState<ITopic[]>([]);

  useEffect(() => {
    getTopics();
  }, []);

  async function getTopics() {
    const response = await api.get('/topic');
    setTopics(response.data);
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
    await api.post('/survey', model);
    back();
  }

  function back() {
    history.goBack();
  }

  return (
    <div className='"container"'>
      <div className="page-header">
        <h1>New Survey</h1>

        <Button variant="dark" onClick={back}>
          Back
        </Button>
      </div>

      <Form onSubmit={onSubmit}>
        <Form.Group className="mb-3" controlId="formBasicTopic">
          <Form.Label>Select Topic</Form.Label>
          <br />{' '}
          <select
            className="custom-select"
            onChange={(e) => {
              console.log(e);
              model.topic.id = Number(e.target.value);
            }}
          >
            {topics.map((item) => (
              <option key={item.id} value={item.id}>
                {item.name}
              </option>
            ))}
          </select>
        </Form.Group>

        <Form.Group className="mb-3" controlId="formBasicQuestion">
          <Form.Label>Survey Question</Form.Label>
          <Form.Control
            type="text"
            name="question"
            onChange={(e: ChangeEvent<HTMLInputElement>) => updateModel(e)}
            placeholder="Enter Survey Question"
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

export default CreateSurvey;
