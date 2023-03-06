import React, {useState, useEffect, useContext} from 'react'
import { useParams } from 'react-router-dom'
import TeamList from '../components/team/TeamList'
import MyCard from '../components/layouts/MyCard'
import AccountContext from '../context/account/AccountContext'
import { useNavigate } from 'react-router-dom'

function League() {

  const [teamList, setTeamList] = useState([])
  const navigate = useNavigate()

  const {id} = useParams()

  const getTeams = async () => {
    
    const response = await fetch(`http://localhost:8080/team/league?id=${id}`, {
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
    
      body.sort(function(a, b) { 
        return a.fPoints - b.fPoints;
      })
      console.log(body)

      setTeamList(body)
    }
  }

  useEffect(() => {

    getTeams()

  }, [])

  return (
    <MyCard title='Team Standings'>
      <TeamList teamList={teamList}/>
    </MyCard>
  )
}

export default League