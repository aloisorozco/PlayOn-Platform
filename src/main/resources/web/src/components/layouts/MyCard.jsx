import React from 'react'
import { Card } from 'react-daisyui'

function MyCard({title, children}) {
  return (
    <div className='grid place-items-center h-[90vh]'>
      <div className="card w-96 bg-sky-800 text-primary-content shadow-md pb-2">
        <div className="card-body items-center space-y-4">
          <Card.Title tag="h2">{title}</Card.Title>
          {children}
        </div>
      </div>
    </div>
  )
}

export default MyCard