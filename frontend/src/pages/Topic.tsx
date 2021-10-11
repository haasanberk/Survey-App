import React, { useState, useEffect } from 'react';
import api from '../services/api';
import { Table, Button } from 'react-bootstrap';
import { useHistory } from 'react-router-dom';

interface IList {
  id: number;
  name: string;
  npm_score: number;
}

const Topic: React.FC = () => {
  const history = useHistory();

  const [topics, setTopics] = useState<IList[]>([]);

  useEffect(() => {
    loadTopics();
  }, []);

  async function loadTopics() {
    const response = await api.get('/topic');
    console.log(response);
    setTopics(response.data);
  }

  function newTopic() {
    history.push('/createtopic');
  }

  return (
    <div className='"container"'>
      <div className="page-header">
        <h1>Topics</h1>
        <Button variant="danger" onClick={newTopic}>
          New
        </Button>
      </div>

      <Table striped bordered hover>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>NPM Score</th>
          </tr>
        </thead>
        <tbody>
          {topics.map((topic) => (
            <tr key={topic.id}>
              <td>{topic.id}</td>
              <td>{topic.name}</td>
              <td>{topic.npm_score}</td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  );
};

export default Topic;
