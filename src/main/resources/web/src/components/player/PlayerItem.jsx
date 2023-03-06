import React, {useContext} from 'react'
import { Link } from 'react-router-dom'
import PlayerPopupContext from '../../context/Player/PlayerPopupContext'

function PlayerItem({player}) {

  const {setPlayer, modalRef} = useContext(PlayerPopupContext)

  const handleClick = (e) => {
    setPlayer(player)
  }

  return (
    <li>
      {/* not a link should be just a pop up */}
      <div className='hover:text-sky-800 flex align-middle space-x-4 mx-2 text-zinc-900' onClick={handleClick}>
        <div>
          <strong>{player.position}</strong>
        </div>
        <div>
          <p className='text-center text-lg'>{player.name}</p>
        </div>
        {/*TODO: justify-end */}
        <div>
          {player.points}
        </div>
      </div>
    </li>
  )
}

export default PlayerItem