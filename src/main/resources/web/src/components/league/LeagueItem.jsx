import React from 'react'
import {Link} from 'react-router-dom'

function LeagueItem({league}) {
  return (
    <li>
      <Link to={`/league/${league.id}`} id={league.id}>
        <p className='text-center text-lg hover:text-sky-800 text-zinc-900'>{league.name}</p>
      </Link>
    </li>
  )
}

export default LeagueItem