import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Navbar from './components/layouts/Navbar';
import Home from './pages/Home';
import PrivateRoute from './pages/PrivateRoute';
import Main from './pages/Main'
import Login from './pages/Login';
import Register from './pages/Register';
import { AccountProvider } from './context/account/AccountContext';
import League from './pages/League';
import Team from './pages/Team';
import NotFound from './pages/NotFound';
import { PlayerPopupProvider } from './context/Player/PlayerPopupContext';
import { AccountPopupProvider } from './context/account/AccountPopupContext';
import JoinLeague from './pages/JoinLeague';

function App() {
  return (
    <PlayerPopupProvider>
    <AccountPopupProvider>
      <AccountProvider>
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route path="/" element={<Home />}/>
          <Route path='/login' element={<Login />}/>
          <Route path='/register' element={<Register />}/>

          <Route path='/main' element={<PrivateRoute />}>
            <Route path='/main' element={<Main />} />
          </Route>

          <Route path='/league/:id' element={<PrivateRoute />}>
            <Route path='/league/:id' element={<League />}/>
          </Route>

          <Route path='/team/:id' element={<PrivateRoute />}>
            <Route path='/team/:id' element={<Team />}/>
          </Route>

          <Route path='/joinleague' element={<PrivateRoute />}>
            <Route path='/joinleague' element={<JoinLeague />}/>
          </Route>

          <Route path='/*' element={<NotFound />}/>
        </Routes>
      </BrowserRouter>
    </AccountProvider>
    </AccountPopupProvider>
    </PlayerPopupProvider>
  );
}

export default App;
