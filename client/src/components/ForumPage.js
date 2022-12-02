import Box from '@mui/material/Box';
import Paper from '@mui/material/Paper';
import Grid from '@mui/material/Grid';
import { styled } from '@mui/material/styles';
import { Container } from '@mui/system';
import {useNavigate} from 'react-router-dom';
import Button from '@mui/material/Button';
import Link from "./ThreadLink";
import agent from "../posts";

const Item = styled(Paper)(({ theme }) => ({
    backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
    ...theme.typography.body2,
    padding: theme.spacing(1),
    textAlign: 'left',
    color: theme.palette.text.secondary,
  }));
/*
const fetchThreads = async () =>{

  const respose = await apiThread.get("/thread");
}
*/

const  ThreadNames= ["Off-topic", "The Well", "Questions", "Hardcore Section"]

//const  ThreadNames= agent.account.getAll;

export default function ForumPage(){
    const navigate = useNavigate();
    const handleSubmit = ({handle}) => {
        navigate(handle);
    };
    return(
        <Container>
            <h2 style={{display: 'flex', justifyContent: 'center', alignItems: 'center', height: "15vh"}}>The greatest Forum</h2>
        <Box sx={{ flexGrow: 1, display: 'flex', justifyContent: 'center', alignItems: 'center', height: "60vh"}} marginLeft ={30}>
        <Grid container spacing={2} direction="column" justifyContent="flex-end" alignItems="stretch">
            {ThreadNames.map(i =>(
            <Link props={i}/>
            ))}
        </Grid>
        </Box>
        </Container>

    );
}

export {ThreadNames};