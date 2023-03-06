import React from 'react'
import { createContext, useState, useRef, useEffect } from 'react'

const PlayerPopupContext = createContext()


export const PlayerPopupProvider = ({children}) => {

  const modalRef = useRef(null)

  const [player, setPlayer] = useState(null)

  useEffect(() => {
    if (player != null) {
      modalRef.current.checked = true;
    }
    else {
      modalRef.current.checked = false;
    }
  }, player)

  const handleChange = (e) => {
    setPlayer(null)
  }

  return (
    <PlayerPopupContext.Provider value={{
      player,
      setPlayer,
      modalRef,
    }}>
      {children}
      <input type="checkbox" id="my-modal-4" className="modal-toggle" ref={modalRef} onChange={handleChange}/>
      <label htmlFor="my-modal-4" className="modal cursor-pointer">
        {/*TODO: styling + display player info*/}
        <label className="modal-box w-5/12 relative bg-sky-800" htmlFor="">
          {(player != null) &&
            (<div className='mx-6'>
              <h3 className="text-lg font-bold text-center flex flex-row space-x-2">
                <strong>{player.position}</strong>
                <p>{player.name}</p>
              </h3>
            
              <div className="mx-2 py-2 space-y-1 grid grid-cols-2 gap-4">
                <div className="flex flex-row space-x-2">
                  <p className='text-lg'><strong>Points</strong></p>
                  <p className="text-lg">{player.totalPoints}</p>
                </div>
                <div className="flex flex-row space-x-2">
                  <p className='text-lg'><strong>Rebounds</strong></p>
                  <p className="text-lg">{player.totalRebounds}</p>
                </div>
                <div className="flex flex-row space-x-2">
                  <p className='text-lg'><strong>Assists</strong></p>
                  <p className="text-lg">{player.totalAssists}</p>
                </div>
                <div className="flex flex-row space-x-2">
                  <p className='text-lg'><strong>Blocks</strong></p>
                  <p className="text-lg">{player.totalBlocks}</p>
                </div>
                <div className="flex flex-row space-x-2">
                  <p className='text-lg'><strong>Steals</strong></p>
                  <p className="text-lg">{player.totalSteals}</p>
                </div>
                <div className="flex flex-row space-x-2">
                  <p className='text-lg'><strong>Turnovers</strong></p>
                  <p className="text-lg">{player.totalTurnovers}</p>
                </div>
                
              </div>
            </div>)
          }
        </label>
      </label>
    </PlayerPopupContext.Provider>
  )
}

export default PlayerPopupContext
