import React from 'react'
import {Link} from 'react-router-dom'
import PlayerItem from './PlayerItem'

function PlayerList({playerList}) {

  return (
    <ul className="menu bg-slate-400 w-80 p-2 rounded-box">

      {playerList.map( (player) => 
        (<PlayerItem player={player} key={player.id}/>)
      )}
    </ul>
  )
}

export default PlayerList