import React, {useState, useContext, useEffect} from 'react'
import { useParams } from 'react-router-dom'
import PlayerList from '../components/player/PlayerList'
import MyCard from '../components/layouts/MyCard'
import AccountContext from '../context/account/AccountContext'
import { useNavigate } from 'react-router-dom'

function Team() {
  
  const [playerList, setPlayerList] = useState([])
  const [team, setTeam] = useState({})
  const navigate = useNavigate()

  const {id} = useParams()

  const getTeam = async () => {
    const response = await fetch(`http://localhost:8080/team?id=${id}`, {
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

      setTeam(body)
      setPlayerList(body.players)
    }
  }

  useEffect(() => {

    getTeam()

  }, [])

  return (
    <MyCard title={team.name}>
      <PlayerList playerList={playerList}/>
    </MyCard>
  )
}

export default Team