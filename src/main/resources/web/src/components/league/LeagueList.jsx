import React from 'react'
import LeagueItem from './LeagueItem'

function LeagueList({leagueList}) {  

  return (
    <ul className="menu bg-slate-400 w-80 p-2 rounded-box">

      {leagueList.map( (league) => 
        (<LeagueItem league={league} key={league.id}/>)
      )}
    </ul>
  )
}

export default LeagueList