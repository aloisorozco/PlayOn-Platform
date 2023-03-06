import React, {useEffect, useContext, useState} from 'react'
import { useNavigate } from 'react-router-dom'
import MyCard from '../components/layouts/MyCard'
import LeagueList from '../components/league/LeagueList'
import AccountContext from '../context/account/AccountContext'
import Cookies from "universal-cookie"
import getId from '../context/account/AccountId'
import { Link } from 'react-router-dom'

function Main() {

  const [leagueList, setLeagueList] = useState([])
  const {id} = useContext(AccountContext)
  const navigate = useNavigate()

  const getLeagues = async (id) => {
    
    const response = await fetch(`http://localhost:8080/league/account?id=${id}`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
         Accept: 'application/json'
      },
    })

    if (response.status >= 400) {
      //alert('invalid credentials')
      //TODO: maybe navigate back to login?
    }
    else {
      const body = await response.json()
    
      console.log(body)

      setLeagueList(body)
    }
  }

  useEffect(() => {
    
    getLeagues(id)

  }, [])

  return (
    <MyCard title='My Leagues'>
      <LeagueList leagueList={leagueList}/>
      <Link to='/joinleague' className='link text-slate-200 link-hover'>Got a league code? Join league</Link>
    </MyCard>
  )
}

export default Main