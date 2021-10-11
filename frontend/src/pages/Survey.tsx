import React, { useState, useEffect } from 'react';
import api from '../services/api';
import { Table, Button } from 'react-bootstrap';
import { useHistory } from 'react-router-dom';

interface IList {
  id: number;
  topic: { id: number; name: string; npm_score: number };
  question: string;
}

const Survey: React.FC = () => {
  const history = useHistory();

  const [surveys, setSurveys] = useState<IList[]>([]);

  useEffect(() => {
    loadSurveys();
  }, []);

  async function loadSurveys() {
    const response = await api.get('/survey');

    console.log(response.data);
    setSurveys(response.data);
  }

  function newSurvey() {
    history.push('/createsurvey');
  }

  return (
    <div className='"container"'>
      <div className="page-header">
        <h1>Surveys</h1>
        <Button variant="danger" onClick={newSurvey}>
          New
        </Button>
      </div>

      <Table striped bordered hover>
        <thead>
          <tr>
            <th>ID</th>
            <th>Topic</th>
            <th>Question</th>
          </tr>
        </thead>
        <tbody>
          {surveys.map((survey) => (
            <tr key={survey.id}>
              <td>{survey.id}</td>
              <td>{survey.topic.name}</td>
              <td>{survey.question}</td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
};

export default Survey;
