import React from 'react'
import MyCard from '../components/layouts/MyCard'
import {Link} from 'react-router-dom'

function Home() {
  return (
    <MyCard>
      <h2 className="card-title text-center">Fantasy Sports in Real Time Playoffs</h2>
      <p>So you can PlayOn all season long!</p>
      <div className="card-actions justify-end">
        <Link to="/register">
        <button className="btn">Get Started</button>
        </Link>
      </div>
    </MyCard>
  )
}

export default Home