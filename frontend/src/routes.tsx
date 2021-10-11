import React from 'react';
import { Switch, Route } from 'react-router';

import Home from './pages/Home';
import Topic from './pages/Topic';
import CreateTopic from './pages/CreateTopic';
import Survey from './pages/Survey';
import CreateSurvey from './pages/CreateSurvey';
import Answer from './pages/Answer';
import CreateAnswer from './pages/CreateAnswer';

const Routes: React.FC = () => {
  return (
    <Switch>
      <Route path="/" exact component={Home} />
      <Route path="/topic" component={Topic} />
      <Route path="/survey" component={Survey} />
      <Route path="/answer" component={Answer} />
      <Route path="/createTopic" component={CreateTopic} />
      <Route path="/createAnswer" component={CreateAnswer} />
      <Route path="/createSurvey" component={CreateSurvey} />
    </Switch>
  );
};

export default Routes;
