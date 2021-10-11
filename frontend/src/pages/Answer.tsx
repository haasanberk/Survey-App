import React, { useState, useEffect } from 'react';
import api from '../services/api';
import { Table, Button } from 'react-bootstrap';
import { useHistory } from 'react-router-dom';

interface IList {
  id: number;
  score: number;
  survey: { id: number; name: string; npm_score: number };
  feedback: string;
}

const Answer: React.FC = () => {
  const history = useHistory();

  const [answers, setAnswers] = useState<IList[]>([]);

  useEffect(() => {
    loadAnswers();
  }, []);

  async function loadAnswers() {
    const response = await api.get('/answer');

    console.log(response.data);
    setAnswers(response.data);
  }

  function newAnswer() {
    history.push('/createanswer');
  }

  return (
    <div className='"container"'>
      <div className="page-header">
        <h1>Answers</h1>
        <Button variant="danger" onClick={newAnswer}>
          New
        </Button>
      </div>

      <Table striped bordered hover>
        <thead>
          <tr>
            <th>ID</th>
            <th>Score</th>
            <th>Feedback</th>
          </tr>
        </thead>
        <tbody>
          {answers.map((answer) => (
            <tr key={answer.id}>
              <td>{answer.id}</td>
              <td>{answer.score}</td>
              <td>{answer.feedback}</td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
};

export default Answer;
