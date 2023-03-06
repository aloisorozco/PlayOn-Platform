import React from 'react'
import PropTypes from 'prop-types'
import {Link} from 'react-router-dom'

function MyForm({inputlist, link}) {
  return (
    <div className="form-control space-y-4">
      {inputlist.map((input) => 
        (<input type={input.type} placeholder={input.name} className="input w-full text-center max-w-xs bg-slate-400 text-zinc-900 placeholder-zinc-500" id={input.name} key={input.name} onChange={input.handleChange}/>)
      )}

      <button type='submit' className='btn btn-ghost'>
        Submit
      </button>

      <Link to={link.location} className='link text-slate-200 link-hover'>{link.text}</Link>
    </div>
  )
}

MyForm.propTypes = {
  inputlist: PropTypes.array
}

export default MyForm