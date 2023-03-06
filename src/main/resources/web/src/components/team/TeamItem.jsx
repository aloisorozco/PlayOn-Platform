import React from 'react'
import {Link} from 'react-router-dom'

function TeamItem({team, index}) {

  return (
    <li>
      <Link to={`/team/${team.id}`} id={team.id} className='hover:text-sky-800 text-zinc-900 flex align-middle space-x-4 mx-2'>
      <div>
          <strong>{index + 1}</strong>
        </div>
        <div>
          <p className='text-center text-lg'>{team.name}</p>
        </div>
        {/*TODO: justify-end */}
        <div>
          {team.fpoints}
        </div>
      </Link>
    </li>
  )
}

export default TeamItem