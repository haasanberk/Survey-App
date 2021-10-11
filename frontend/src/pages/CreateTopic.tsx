import React, { useState, ChangeEvent } from 'react';
import api from '../services/api';
import { Form, Button } from 'react-bootstrap';
import './index.css';
import { useHistory } from 'react-router-dom';

interface ITopic {
  name: string;
  npm_score: number;
}

const CreateTopic: React.FC = () => {
  const history = useHistory();

  const [model, setModel] = useState<ITopic>({
    name: '',
    npm_score: 0,
  });

  function updateModel(e: ChangeEvent<HTMLInputElement>) {
    setModel({
      ...model,
      [e.target.name]: e.target.value,
    });
  }

  async function onSubmit(e: ChangeEvent<HTMLFormElement>) {
    e.preventDefault();
    await api.post('/topic', model);
    back();
  }

  function back() {
    history.goBack();
  }

  return (
    <div className='"container"'>
      <div className="page-header">
        <h1>New Topic</h1>

        <Button variant="dark" onClick={back}>
          Back
        </Button>
      </div>
      <Form onSubmit={onSubmit}>
        <Form.Group className="mb-3" controlId="formBasicName">
          <Form.Label>Topic Name</Form.Label>
          <Form.Control
            type="text"
            name="name"
            onChange={(e: ChangeEvent<HTMLInputElement>) => updateModel(e)}
            placeholder="Enter Topic Name"
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

export default CreateTopic;
