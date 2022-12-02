import Box from '@mui/material/Box';
import Paper from '@mui/material/Paper';
import Grid from '@mui/material/Grid';
import { styled } from '@mui/material/styles';
import { Container } from '@mui/system';
import {useNavigate} from 'react-router-dom';
import Button from '@mui/material/Button';
import Link from "./ThreadLink";

const Item = styled(Paper)(({ theme }) => ({
    backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
    ...theme.typography.body2,
    padding: theme.spacing(1),
    textAlign: 'left',
    color: theme.palette.text.secondary,
  }));


export default function Thread({props}){
    return(
        
        <Box sx={{ flexGrow: 1}}>
            <p>Welcome to {props}</p>
            <Button>New Post</Button>
        <Grid container spacing={2} direction="column" justifyContent="flex-end" alignItems="stretch" margin ={10}>
            <Grid>
                <Item>
                <Grid><Item>Title</Item></Grid>
                <Grid><Item>Post</Item></Grid>
                <Grid><Item>Image</Item></Grid>
                </Item>
            </Grid>
        </Grid>
        </Box>
    );
}