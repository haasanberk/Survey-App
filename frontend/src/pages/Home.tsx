import React, { useState, useEffect } from 'react';
import api from '../services/api';
import { Table, Button } from 'react-bootstrap';
import { useHistory } from 'react-router-dom';

const Home: React.FC = () => {
  return (
    <div className='"container"'>
      <div className="page-header">
        <h1>Aegon Interview Task</h1>
      </div>
    </div>
  );
};

export default Home;
