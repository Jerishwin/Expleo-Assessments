import fs from 'fs'
import path from 'path'
import{parse} from 'csv-parse/sync'

export interface user{
    type:string
    fname:string
    lname:string
    email:string
    pass:string
}

export function readRegister():user[]{
    const filepath = path.resolve(__dirname,'../test-data/register.csv')
    const filecontent = fs.readFileSync(filepath,'utf-8')

    return parse(filecontent,{
        columns:true,
        skip_empty_lines:true,
        trim:true
    })as user[]

}
