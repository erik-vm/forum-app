import Box from '@mui/material/Box';
import Paper from '@mui/material/Paper';
import Grid from '@mui/material/Grid';
import { styled } from '@mui/material/styles';
import { Container } from '@mui/system';

const Item = styled(Paper)(({ theme }) => ({
    backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
    ...theme.typography.body2,
    padding: theme.spacing(1),
    color: theme.palette.text.secondary,
  }));

export default function ForumPage(){
    return(
        <Container>
            <h2 style={{display: 'flex', justifyContent: 'center', alignItems: 'center', height: "15vh"}}>The greatest Forum</h2>
        <Box sx={{ flexGrow: 1, display: 'flex', justifyContent: 'center', alignItems: 'center', height: "60vh"}} marginLeft ={30}>
        <Grid container spacing={2} direction="column" justifyContent="flex-end" alignItems="stretch">
            <Grid item>
            <Item>Off-topic</Item>
            </Grid>
            <Grid item>
            <Item>The Well</Item>
            </Grid>
            <Grid item>
            <Item>Questions</Item>
            </Grid>
            <Grid item>
            <Item>Hardcore Section</Item>
            </Grid>
        </Grid>
        </Box>
        </Container>

    );

}