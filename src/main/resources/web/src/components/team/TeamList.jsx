import React from 'react'
import TeamItem from './TeamItem'

function TeamList({teamList}) {

  return (
    <ul className="menu bg-slate-400 w-80 p-2 rounded-box">

      {teamList.map( (team, index) => 
        (<TeamItem team={team} key={team.id} index={index}/>)
      )}
    </ul>
  )
}

export default TeamList