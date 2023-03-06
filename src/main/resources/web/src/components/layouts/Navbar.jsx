import React, { useContext, useEffect, useState } from 'react'
import {Link, useNavigate} from 'react-router-dom'
import AccountContext from '../../context/account/AccountContext'
import { removeId } from '../../context/account/AccountId'

function Navbar() {

  const [loading, setLoading] = useState(true)
  const {id, setId, onPageLoad} = useContext(AccountContext)
  const navigate = useNavigate()

  useEffect(() => {
    onPageLoad()
    setLoading(false)
  }, [])
  
  const signOut = () => {
    setId(false)
    localStorage.clear()
    navigate('/')
  }

  return (
    <div className="navbar bg-slate-800 border-b-1 border-b-sky-800 h-[10vh]">
      <div className="navbar-start">
        {/* <div className="dropdown">
          <label tabIndex={0} className="btn btn-ghost btn-circle">
            <svg xmlns="http://www.w3.org/2000/svg" className="h-5 w-5" fill="none" viewBox="0 0 24 24" stroke="currentColor"><path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M4 6h16M4 12h16M4 18h7" /></svg>
          </label>
          <ul tabIndex={0} className="menu menu-compact dropdown-content mt-3 p-2 shadow bg-base-100 rounded-box w-52">
            <li><a>Homepage</a></li>
            <li><a>Portfolio</a></li>
            <li><a>About</a></li>
          </ul>
        </div> */}
      </div>
      
      <div className="navbar-center">
        <Link className="btn btn-ghost normal-case text-3xl" to='/'>PlayOn Fantasy</Link>
      </div>
      <div className="navbar-end pt-2 pr-4">
        
        {(!loading) && ((!id) ?
        (<>
        <Link to='/login'>
          <button className="btn btn-ghost btn-sm mx-4">
            Login
          </button>
        </Link>
        <Link to='/register'>
          <button className="btn btn-ghost btn-sm mx-4">
            Register
          </button>
        </Link></>)
        :
        (<button onClick={signOut} className="btn btn-ghost btn-sm mx-4">
          Sign out
        </button>))}
      </div>
    </div>
  )
}

export default Navbar