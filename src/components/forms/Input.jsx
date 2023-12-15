export function Input({label,value,updateValue}){
    return(
        <>  
            <div className="form-group">
                <label>{label}</label>
                <input className="form-control" value={value} onChange={event => updateValue(event.target.value)}></input>
            </div>
            <br />
        </>
    )
}